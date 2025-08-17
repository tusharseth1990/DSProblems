package designpattern.strategy;

public class StrategyPatternDemo {

    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment());
        context.executePayment(100);

        context.setPaymentStrategy(new PayPalPayment());
        context.executePayment(250);
    }
}
