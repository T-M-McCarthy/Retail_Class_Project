package TheFinalProject;

import java.util.*;
import java.lang.Math;


public class Bill{
    double total;
    private  ArrayList<String> shoppingItems = new ArrayList<>();
    private HashMap<String, Double> values = new HashMap<>();

    String[] items;
    Integer[] quantity;



    public Bill(){
    }

    /**
     *
     * @param shoppingItems this is needed to form one of the arrays to be fed into the total and payment methods. It stores the different Items
     * @param itemQuantity  this is needed to form one of the arrays to be fed into the total and payment methods. It stores the amount of each item
     */
    public Bill(ArrayList<String> shoppingItems, ArrayList<Integer> itemQuantity){
        this.shoppingItems = shoppingItems;
        items = new String[shoppingItems.size()];
        quantity = new Integer[itemQuantity.size()];
        items = shoppingItems.toArray(items);
        quantity = itemQuantity.toArray(quantity);

        }


    /**
     *
     * @param customerFound grabs the variable that denotes if the user is a card holding member
     * @return returns the total cost of the sale
     */

    public double total(boolean customerFound) {
        // two hash maps are used to quickly and efficiently sort through all data
        HashMap<String, Double> values = new HashMap<>();
        values.put("cereal", 2.00);
        values.put("shampoo", 3.00);
        values.put("canned vegetables", 3.50);
        HashMap<String, Integer> totalMap = new HashMap<>();
        for (int i = 0; i < shoppingItems.size(); i++) {
            totalMap.put(items[i], quantity[i]);
        }
        double total = 0.0;
            for (String item : totalMap.keySet()) {
                int quantity = totalMap.get(item);
                if (values.containsKey(item)) {
                        if (customerFound){
                            switch (item) {
                                case "cereal" -> {
                                    // The following algorithm is adapted from the CerealBox class created by Seska Linn
                                    int setsOfFour = quantity / 4;
                                    int remainingCereals = quantity % 4;
                                    double discountedPrice = values.get(item) * 0.5;
                                    double regularPrice = values.get(item);
                                    total += setsOfFour * (discountedPrice * 4) + remainingCereals * regularPrice;
                                }
                                case "shampoo" -> {
                                    // The following algorithm is adapted from the Shampoo class created by Wesley Freeman
                                    int setsOfTwo = quantity / 2;
                                    int remainingShampoos = quantity % 2;
                                    double shampooPrice = values.get(item);
                                    total += setsOfTwo * 3.00 + remainingShampoos * shampooPrice;
                                }
                                case "canned vegetables" -> {
                                    // The following algorithm is adapted from the Canned Vegetables class created by Joshua Garcia
                                    int setsOfThree = quantity / 3;
                                    int remainingSoups = quantity % 3;
                                    double soupPrice = values.get(item);
                                    double specialOfferPrice = setsOfThree * 10.50;
                                    double remainingItemsPrice = remainingSoups * soupPrice;
                                    total += specialOfferPrice + remainingItemsPrice;
                                }
                                default -> total +=  quantity;
                            }
                } else {

                            switch (item) {
                                case "cereal" -> total += quantity * 2.00;
                                case "shampoo" -> total += quantity * 3.00;
                                case "canned vegetables" -> total += quantity * 3.50;
                                default -> total += quantity;
                            }
                        }

                    } else {
                    total += quantity;
                    }
                }
                 System.out.println(totalMap);
            return total;
            }


    /**
     *
     * @param total This is used to determine how much the system needs to be paid. the parameter due is based on total- cash supplied to store.
     */
    public void payment(double total) {
        System.out.println("Total: " + total);
        System.out.println("please insert cash");
        System.out.println("How much cash was given?");
        Scanner bob = new Scanner(System.in);
        double cash = bob.nextDouble();
        if (total - cash < 0 ){
            System.out.println("Thank you for shopping at our Final Project");
            System.out.printf("Your change is: $%.2f%n",  Math.abs(total- cash));
        }
        else if (total- cash > 0) {
            System.out.println("Insufficient funds.");
            double due = total- cash;
            while (due > 0 ){
                System.out.println("please insert cash");
                System.out.println("How much cash was given?");
                due = (due - bob.nextDouble()) ;
            }
            if (due < 0){
                System.out.println("Thank you for shopping at our Final Project");
                System.out.printf("Your change is: $%.2f%n", Math.abs(due));
            }
        }
        else{
            System.out.println("Thank you for shopping at our Final Project");
            System.out.println("Have a nice day!");
        }
    }
}




