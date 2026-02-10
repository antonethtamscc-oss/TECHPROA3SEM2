
		public class PaymentProcessor {

    // Process payment with two arguments: amount and currency
    public void processPayment(double amount, String currency) {
        System.out.println("Processing payment of " + amount + " " + currency);
    }

    // Overloaded method with three arguments: amount, currency, and payment method
    public void processPayment(double amount, String currency, String paymentMethod) {
        System.out.println("Processing payment of " + amount + " " + currency + " via " + paymentMethod);
    }

    public static void main(String[] args) {
        PaymentProcessor p = new PaymentProcessor();

        // Test 2-argument method
        p.processPayment(1000.0, "PHP");

        // Test 3-argument method
        p.processPayment(1200.0, "USD", "Credit Card");
	}
}
