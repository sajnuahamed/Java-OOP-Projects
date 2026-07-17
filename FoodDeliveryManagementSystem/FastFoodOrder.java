
/**
 * Represents a fast food order.
 * Adds delivery charges and fast-food-specific tracking behavior.
 */

public class FastFoodOrder extends Order {

    private double deliveryCharge;

    public FastFoodOrder(int orderId, String customerName, double orderPrice, double deliveryCharge) {
        super(orderId, customerName, orderPrice);
        this.deliveryCharge = deliveryCharge;
    }

    @Override
    public double calculateFinalBill() {
        return getOrderPrice() + deliveryCharge;
    }

    @Override
    public void displayDetails() {
        System.out.println("🍔 Fast Food Order");
        System.out.println("=====================");
        System.out.println(this);
    }

    @Override
    public void trackOrder() {
        setTrackStatus(Trackable.PROCESS_FASTFOOD);
    }

    public double getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(double deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nDelivery Charge : " + deliveryCharge
                + "\nTotal Bill : " + calculateFinalBill();
    }

}
