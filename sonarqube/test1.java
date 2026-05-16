public class DiscountCalculator {

    public double calculateDiscount(double price, String customerType) {
        if (customerType == "VIP") {
            return price * 0.20;
        } else if (customerType == "VIP") {
            return price * 0.15;
        } else if (price > 1000) {
            return price * 0.10;
        } else {
            return 0;
        }
    }
}
