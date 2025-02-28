package TheFinalProject;

/**
 * \
 * Creates a LoyaltyCard Class to work with customers within the Grocery and
 * Retail Class
 *
 */
public class LoyaltyCard {

    private String customerFirstName;
    private String customerLastName;
    private int points;

    /**
     * \
     * Overloaded constructor that creates a loyalty card to the customer
     * created Also associates the points earned from shopping
     *
     * @param customerFirstName
     * @param customerLastName
     */
    public LoyaltyCard(String customerFirstName, String customerLastName) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.points = 0;
    }

    /**
     * \
     * Allows the user to get the customer's first name
     *
     * @return customerFirstName
     */
    public String getCustomerFirstName() {
        return customerFirstName;
    }

    /**
     * \
     * Sets the customer's first name
     *
     * @param customerFirstName
     */
    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    /**
     * \
     * Allows the user to get the customer's last name
     *
     * @return customerLastName
     */
    public String getCustomerLastName() {
        return customerLastName;
    }

    /**
     * \
     * Sets the customer's last name
     *
     * @param customerLastName
     */
    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    /**
     * \
     * Allows the user to get the points after shopping to store in the loyalty
     * card
     *
     * @return points
     */
    public int getPoints() {
        return points;
    }

    /**
     * \
     * Sets the points to the customer's loyalty card
     *
     * @param points
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * \
     * Method to add points to the loyalty card
     * @param purchaseAmount
     */
    public void addPoints(double purchaseAmount) {
        int newPoints = ((int) purchaseAmount / 20) * 5;
        this.points += newPoints;
    }

    /**
     * \
     * Method to redeem points for a discount
     * @return 
     */
    public double getDiscountAmount() {
        if (this.points >= 500) {
            System.out.println("You have 500 points or more, so you get a $10 discount!");
            this.points -= 500;
            return 10.0;
        }
        return 0.0;
    }
}
