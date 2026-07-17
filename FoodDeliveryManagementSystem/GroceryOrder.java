
/**
 * Represents a grocery order.
 * Calculates the final bill by including packing and delivery charges.
 */

public class GroceryOrder extends Order{

    private double packingFee;
    private double deliveryCharge;

    public GroceryOrder(int orderId, String customerName, double orderPrice, double packingFee, double deliveryCharge) {
        super(orderId, customerName, orderPrice);
        this.packingFee = packingFee;
        this.deliveryCharge = deliveryCharge;
    }

    @Override
    public double calculateFinalBill() {
        return getOrderPrice() + packingFee + deliveryCharge;
    }

    @Override
    public void trackOrder() {
        setTrackStatus(Trackable.PROCESS_GROCERY);
    }

    @Override
    public void displayDetails() {
        System.out.println("🛒 Grocery Order");
        System.out.println("=====================");
        System.out.println(this);
    }

    public double getPackingFee() {
        return packingFee;
    }

    public void setPackingFee(double packingFee) {
        this.packingFee = packingFee;
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
                + "\nPacking Fee : " + packingFee
                + "\nDelivery Charge : " + deliveryCharge
                + "\nTotal Bill : " + calculateFinalBill();
    }

}
