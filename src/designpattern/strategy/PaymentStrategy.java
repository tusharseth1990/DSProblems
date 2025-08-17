package designpattern.strategy;

@FunctionalInterface
public interface PaymentStrategy {

    void pay(double amount);
}
