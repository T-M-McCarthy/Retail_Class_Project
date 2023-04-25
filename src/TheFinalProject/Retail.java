package TheFinalProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
The Retail class was created by Thomas McCarthy
Edited and Revised for integration and comprehension by Paul Ferris
 */
public class Retail {

    // customer Input is a class intended to make the options menu less cluttered and more accessible
    public static void customerInput() {
        System.out.println("1. Checkout");
        System.out.println("2. Create New Customer");
        System.out.println("3. Update Existing Customer");
        System.out.println("4. Search Customer");
        System.out.println("5. Delete Customer");
        System.out.println("6. Exit");
    }

    public static void main(String[] args) {
        ArrayList<Grocery> customerInfo = new ArrayList<>();
        boolean existingCustomer = false;
        boolean customerFound = false;
        int option;
        ArrayList<String> shoppingItems = new ArrayList<>();
        ArrayList<Integer> itemQuantity = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to <Generic Supermarket>");
        System.out.println("1. Checkout with a membership");
        System.out.println("2. Checkout without a membership");
        System.out.println("3. Exit");
        option = in.nextInt();
        /* This switch was implemented to give the user a chance to opt out of coupons and deals. This design choice
        * was made due to real world applications. People opt for their information to not be stored and would be
        * willing to pay more for that.
         */
        switch (option) {

            case 1 -> {
                Grocery customer = new Grocery();
                customerInfo.add(customer);
                do {
                    customerInput();
                    System.out.println("Enter your option: ");
                    option = in.nextInt();
                    // The following switch is designed to allow for the user to use their account/loyalty card to receive
                    // discounts OR to sign up as a member.
                    switch (option) {
                        case 1 -> {
                            // Case one is designed to be the go-to option for checking out at a store. It checks if
                            // you are a member and will not let you checkout with the discounts unless you are a member
                            System.out.println("Enter customer's first name to search: ");
                            String findFirstName = in.next();
                            System.out.println("Enter customer's last name to search: ");
                            String findLastName = in.next();

                            for (Grocery findCustomer : customerInfo) {
                                if (findCustomer.getCustomerFirstName().equalsIgnoreCase(findFirstName) && findCustomer.getCustomerLastName().equalsIgnoreCase(findLastName)) {
                                    System.out.println("Customer name: " + findCustomer.getCustomerFirstName() + " " + findCustomer.getCustomerLastName());
                                    customerFound = true;
                                    break;
                                }
                            }
                            if (!customerFound) {
                                System.out.println("Customer not found");
                                break;
                            }

                            System.out.println("For every 20 dollars, you get 5 points AND when you reach 500 points, you will get a 10 dollar discount!");

                            for (int i = 0; i < 6; i++) {
                                /* I edited the logic of this code to include a switch so people could exit prior to
                                     * the end of the for loop. A while loop would be much better in applications
                                     * while (in.next().toLowerCase() != "exit" || in.next().toLowerCase() != "done" || in.next().toLowerCase() != "q")
                                     * I decided to keep in the for loop to allow for quick testing of all 3 products and not worrying about returned null values if
                                     * the algorithm ended in an odd spot
                                 */

                                // This is the basis of the storage of values in the program
                                in.nextLine();
                                System.out.println("Please Enter the Item You Wish to Purchase: ");
                                String items = in.nextLine();
                                System.out.println("Please Enter the amount of this item: ");
                                int quantity = in.nextInt();
                                shoppingItems.add(items.toLowerCase());
                                itemQuantity.add(quantity);

                            }

                            customer.setShoppingItems(shoppingItems);
                            customer.setItemQuantity(itemQuantity);

                            for (Grocery name : customerInfo) {
                                System.out.println(name);
                            }
                            // A bill object is created to send the arrays storing the items and the quantity of items
                            // to the object so the class can be used.
                            Bill bob = new Bill(shoppingItems, itemQuantity);

                            // The following operations are performed using algorithms from the classes created by Seska Linn, Wesley Freeman, and Joshua Garcia.
                            bob.payment(bob.total(customerFound) - customer.getDiscountAmount());

                            // The following operations utilize the loyalty card class created by Joshua Collins
                            customer.addPoints(bob.total(customerFound));
                            System.out.println("You have " + customer.getPoints() + " loyalty points.");
                        }

                        case 2 -> {
                            // If the User is new, They can create their own membership
                            System.out.println("Add Customer");
                            System.out.println("Please Enter Customer First Name: ");
                            String firstName = in.next();
                            System.out.println("Please Enter Customer Second Name: ");
                            String lastName = in.next();
                            // The following code is used to ensure no redundancies exist in the lists
                            for (Grocery findCustomer : customerInfo) {
                                if (findCustomer.getCustomerFirstName().equalsIgnoreCase(firstName) && findCustomer.getCustomerLastName().equalsIgnoreCase(lastName)) {
                                    System.out.println("This Individual is Already an Existing Customer");
                                    System.out.println("Do you want to continue shopping? Y or N");
                                    String answer = in.next();
                                    existingCustomer = !answer.equalsIgnoreCase("Y");
                                }
                            }
                            if (!existingCustomer) {
                                System.out.println("Welcome to the <Generic Superstore> family!");
                                customer.setCustomerFirstName(firstName);
                                customer.setCustomerLastName(lastName);
                                customer.makeCard();
                            }
                        }

                        case 3 -> {
                            // Sometimes people make typos when making a profile, or some life event happened for their
                            // name to change. This case allows Customers to change their names to match their preferences
                            System.out.println("Update Customer");
                            System.out.println("Please Enter the Customer's First Name You Wish to Update: ");
                            String searchFirstName = in.next();
                            System.out.println("Please Enter the Customer's Last Name You Wish to Update: ");
                            String searchLastName = in.next();
                            for (Grocery updateCustomer : customerInfo) {
                                if (updateCustomer.getCustomerFirstName().equalsIgnoreCase(searchFirstName) && updateCustomer.getCustomerLastName().equalsIgnoreCase(searchLastName)) {
                                    System.out.println("Please Enter New Customer's First Name: ");
                                    String newFirstName = in.next();
                                    updateCustomer.setCustomerFirstName(newFirstName);
                                    System.out.println("Please Enter New Customer's Last Name: ");
                                    String newLastName = in.next();
                                    updateCustomer.setCustomerLastName(newLastName);
                                    break;
                                } else {
                                    System.out.println("Customer not found. Please Try Again.");
                                }
                            }
                        }
                        case 4 -> {
                            // Sometimes people need to see if they are a member or not before they make a decision on
                            // buying from a place. This class allows the user to check if they are in the system
                            System.out.println("Search Customer");
                            System.out.println("Enter customer's first name to search: ");
                            String findFirstName = in.next();
                            System.out.println("Enter customer's last name to search: ");
                            String findLastName = in.next();

                            for (Grocery findCustomer : customerInfo) {
                                if (findCustomer.getCustomerFirstName().equalsIgnoreCase(findFirstName) && findCustomer.getCustomerLastName().equalsIgnoreCase(findLastName)) {
                                    System.out.println("Customer name: " + findCustomer.getCustomerFirstName() + " " + findCustomer.getCustomerLastName());
                                    customerFound = true;
                                    break;
                                }
                            }
                            if (!customerFound) {
                                System.out.println("Customer not found");
                            }
                            System.out.println();
                        }
                        case 5 -> {
                            // case 5 is set up to remove a customer
                            System.out.println("Delete Customer");
                            System.out.println("Enter Customer's First Name: ");
                            String deleteFirstName = in.next();
                            System.out.println("Enter Customer's Last Name: ");
                            String deleteLastName = in.next();
                            Grocery customerToDelete = null; // Create a reference to the customer to delete
                            for (Grocery deleteCustomer : customerInfo) {
                                if (deleteCustomer.getCustomerFirstName().equalsIgnoreCase(deleteFirstName) && deleteCustomer.getCustomerLastName().equalsIgnoreCase(deleteLastName)) {
                                    System.out.println("Customer Name: " + deleteCustomer.getCustomerFirstName() + " " + deleteCustomer.getCustomerLastName());
                                    System.out.println("Are You Sure You Want To Delete This Customer? Please Enter: Y or N ");
                                    String confirm = in.next();

                                    if (confirm.equalsIgnoreCase("Y")) {
                                        customerToDelete = deleteCustomer; // Set the customer to delete
                                        break;
                                    }
                                }
                            }
                            if (customerToDelete != null) {
                                customerInfo.remove(customerToDelete); // Remove the customer from the ArrayList
                                System.out.println("Customer has been deleted.");
                            } else {
                                System.out.println("Customer not found.");
                            }
                        }
                        // Case 6 is the early, but voluntary exit in the program
                        case 6 ->
                            System.out.println("Exit");
                        default ->
                            System.out.println("Invalid choice");
                    }

                } while (option
                        != 6);
            }
            case 2 -> {
                // This program is simply set up to charge the user without a discount
                System.out.println("To apply coupons, go back and select option 1 and make a membership");
                for (int i = 0; i < 6; i++) {
                    in.nextLine();
                    System.out.println("Please Enter the Item You Wish to Purchase: ");
                    String items = in.nextLine();
                    System.out.println("Please Enter the amount of this item: ");
                    int quantity = in.nextInt();
                    shoppingItems.add(items);
                    itemQuantity.add(quantity);
                    Bill bob = new Bill(shoppingItems, itemQuantity);
                    bob.payment(bob.total(customerFound));
                }
            }

            case 3 ->
                System.out.println("Exiting");

            default ->
                System.out.println("Have a nice day!");
        }
    }
}
