
/**
 * Defines tracking behavior for orders. Provides common tracking status
 * messages used throughout the application.
 */
public interface Trackable {

    // Common Tracking Messages
    String ORDER_PLACED = "Order Placed.";
    String DISPATCHED = "Dispatched";
    String IN_TRANSIT = "In Transit";
    String OUT_FOR_DELIVERY = "Out for Delivery";
    String DELIVERED = "Delivered";

    //Tracking Messages for Processing
    String PROCESS_FASTFOOD = "Preparing your food..";
    String PROCESS_FINEDINING = "Chef is preparing your meal..";
    String PROCESS_GROCERY = "Packing groceries..";

    public void trackOrder();
}
