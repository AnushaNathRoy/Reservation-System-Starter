package flight.reservation.payment;

public class PaypalStrategy implements PaymentStrategy {
    private String email;
    private String password;
    Paypal paypal;

    public PaypalStrategy(String email, String password) {
        this.email = email;
        this.password = password;
        this.paypal = new Paypal();

    }

    @Override
    public boolean pay(double amount) throws IllegalStateException{
        if (email.equals(Paypal.DATA_BASE.get(password))) {
            System.out.println("Paying " + amount + " using PayPal.");
            return true;
        } else {
            return false;
        }
    }
}
