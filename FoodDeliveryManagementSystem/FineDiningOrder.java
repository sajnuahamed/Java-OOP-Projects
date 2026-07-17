
/**
 * Represents a fine dining order.
 * Includes a service charge and restaurant-specific order tracking.
 */

public class FineDiningOrder extends Order {

    private double serviceCharge;

    public FineDiningOrder(int orderId, String customerName, double orderPrice, double serviceCharge) {
        super(orderId, customerName, orderPrice);
        this.serviceCharge = serviceCharge;
    }

    @Override
    public double calculateFinalBill() {
        return getOrderPrice() + serviceCharge;
    }

    @Override
    public void trackOrder() {
        setTrackStatus(Trackable.PROCESS_FINEDINING);
    }

    @Override
    public void displayDetails() {
        System.out.println("🍽 Fine Dining Order");
        System.out.println("=====================");
        System.out.println(this);
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

      @Override
    public String toString() {
        return super.toString()
                + "\nService Charge : " + serviceCharge
                + "\nTotal Bill : " + calculateFinalBill();
    }
    
}
