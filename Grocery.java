package TheFinalProject;



import java.util.ArrayList;
/**\
 * Creates a Grocery Class to work with data within the Retail Class 
 * creates the ArrayLists shoppingItems, itemQuantity, and a LoyaltyCard to be associated with the Grocery ArrayList in Retail Class
 */

public class Grocery {

    private String items, firstName, lastName;
    private int quantity, index;
    private ArrayList<String> shoppingItems;
    private ArrayList<Integer> itemQuantity;
    private LoyaltyCard loyaltyCard;

 /**\
 * Default constructor with the designated values
 */
    public Grocery(){
    firstName = " ";
    lastName = " ";
    }
/**\
 * Overloaded constructor that stores the first name and last name of the customer
 * Also associates and stores the shopping items with this customer 
 * @param firstName
 * @param lastName 
 */
    public Grocery(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.shoppingItems = new ArrayList<>();

    }
/**\
 * Allows the Customer to be displayed with multiple value types 
 * @return the customer
 */
    @Override
    public String toString() {
        return "Customer Name: " + firstName + " " + lastName + ", Shopping Items: " + shoppingItems + ", Item Quantities: " + itemQuantity;
    }
    public void makeCard(){
        this.loyaltyCard = new LoyaltyCard(firstName, lastName);
    }
    /**\
 * Sets the customer's first name 
 * @param firstName 
 */
    public void setCustomerFirstName(String firstName) {
        this.firstName = firstName;
    }
/**\
 * Allows the user to get the customer's first name 
 * @return firstName
 */
    public String getCustomerFirstName() {
        return firstName;
    }
/**\
 * Sets the customer's last name 
 * @param lastName 
 */
    public void setCustomerLastName(String lastName) {
        this.lastName = lastName;
    }
/**\
 * Allows the user to get the customer's last name 
 * @return lastName
 */
    public String getCustomerLastName() {
        return lastName;
    }
/**\
 * Stores the shopping items within the ArrayList associated to the Grocery ArrayList
 * @param shoppingItems 
 */
    public void setShoppingItems(ArrayList<String> shoppingItems) {
        this.shoppingItems = shoppingItems;
    }
/**\
 * Stores the quantity of the items within the ArrayList associated to the Grocery ArrayList
 * @param itemQuantity 
 */
    public void setItemQuantity(ArrayList<Integer> itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
/**\
 * Allows the user to get the customer's shopping items that are stored within the ArrayList 
 * @return shoppingItems
 */
    public ArrayList<String> getShoppingItems() {
        return shoppingItems;
    }
/**\
 * Allows the user to get the customer's quantity of the shopping items that are stored within the ArrayList 
 * @return itemQuantity
 */
    public ArrayList<Integer> getItemQuantity() {
        return itemQuantity;
    }
/**\
 * adds the points to the loyalty card
 * @param purchaseAmount 
 */
    public void addPoints(double purchaseAmount) {
        this.loyaltyCard.addPoints(purchaseAmount);
    }
/**\
 * Allows the user to get the discount amount from the points 
 * @return loyaltyCard
 */
    public double getDiscountAmount() {
        return this.loyaltyCard.getDiscountAmount();
    }
/**\
 * Allows the user to get the points in the loyalty card 
 * @return loyaltyCard
 */
    public int getPoints() {
        return this.loyaltyCard.getPoints();
    }

}
