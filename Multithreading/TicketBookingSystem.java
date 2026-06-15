package JAVA_DAY_15;
interface NotificationService {
    void sendMessage();
}

class EmailNotification implements NotificationService {

    @Override
    public void sendMessage() {
        System.out.println("Email Notification Sent");
    }
}

class SMSNotification implements NotificationService {

    @Override
    public void sendMessage() {
        System.out.println("SMS Notification Sent");
    }
}

class OrderService {

    private NotificationService notificationService;

    public OrderService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void placeOrder() {
        System.out.println("Order Confirmed");
        notificationService.sendMessage();
    }
}

public class ONLINE_FOOD_ORDER_NOTIFICATION {

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	
        NotificationService email = new EmailNotification();
        OrderService order1 = new OrderService(email);

        order1.placeOrder();

        System.out.println();

       
        NotificationService sms = new SMSNotification();
        OrderService order2 = new OrderService(sms);

        order2.placeOrder();
    }
}
