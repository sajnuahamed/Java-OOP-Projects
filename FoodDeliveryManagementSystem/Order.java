
/**
 * Abstract base class representing a food delivery order.
 * Stores common order information and defines behaviors shared
 * by all order types.
 */

public abstract class Order implements Trackable {

    private int orderId;
    private String customerName;
    private double orderPrice;
    private String trackStatus;

    public Order(int orderId, String customerName, double orderPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderPrice = orderPrice;
        this.trackStatus = Trackable.ORDER_PLACED;
    }

    public abstract void displayDetails();

    public abstract double calculateFinalBill();

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getTrackStatus() {
        return trackStatus;
    }

    public void setTrackStatus(String trackStatus) {
        this.trackStatus = trackStatus;
    }

    @Override
    public String toString() {
        return "Order Id : " + orderId
                + "\nCustomer Name : " + customerName
                + "\nOrder Price : " + orderPrice
                + "\nTracking Status : " + trackStatus;
    }
}
