package oa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DiscountCalc {

    // Discount calculation method
    int discCalc(Pizza[] pizzas, OrderItem[] orderItems) {
        int total = 0;
        ArrayList<Integer> prices = new ArrayList<>();
        int largePizzaCount = 0;
        int smallPizzaCount = 0;
        int mediumPizzaCount = 0;
        boolean discountApplied = false;

        // Step 1: Validate if ordered pizzas are available in the menu
        HashMap<String, Pizza> menu = new HashMap<>();
        for (Pizza pizza : pizzas) {
            menu.put(pizza.getName().toLowerCase(), pizza);
        }

        // Step 2: Calculate the total price and count large/small/medium pizzas
        for (OrderItem order : orderItems) {
            Pizza menuItem = menu.get(order.getName().toLowerCase());
            if (menuItem == null) {
                System.out.println("Pizza not available on the menu: " + order.getName());
                return -1;  // Pizza not available
            }

            // Verify the size and set the price according to the size
            int price = 0;
            if (order.getSize().equalsIgnoreCase("small")) {
                price = menuItem.getPriceSmall();
                smallPizzaCount++;
            } else if (order.getSize().equalsIgnoreCase("medium")) {
                price = menuItem.getPriceMedium();
                mediumPizzaCount++;
            } else if (order.getSize().equalsIgnoreCase("large")) {
                price = menuItem.getPriceLarge();
                largePizzaCount++;
            } else {
                System.out.println("Invalid pizza size: " + order.getSize());
                return -1;  // Invalid size
            }

            // Set the order price and add it to the total
            order.setPrice(price);
            total += price;
            prices.add(price);
        }

        // Step 3: Apply Buy 3, get the lowest price one free
        if (orderItems.length >= 3) {
            // Get the lowest priced item
            int minPrice = Collections.min(prices);
            total -= minPrice; // Subtract the price of the lowest one
            discountApplied = true;  // Mark that a discount was applied
        }

        // Step 4: Apply Buy 5, get $100 discount
        if (orderItems.length >= 5) {
            total -= 100;
            discountApplied = true;
        }

        // Step 5: Buy a large pizza, get a small pizza free
        if (largePizzaCount >= 1 && smallPizzaCount >= 1) {
            // Find the price of one small pizza and subtract it from the total
            for (OrderItem order : orderItems) {
                if (order.getSize().equalsIgnoreCase("small")) {
                    total -= order.getPrice();
                    discountApplied = true;
                    break;
                }
            }
        }

        // Step 6: Buy 3 large pizzas, pay the price of 3 mediums
        if (largePizzaCount >= 3) {
            int mediumPriceSum = 0;
            int mediumPizzaFound = 0;

            // Find the total cost of 3 medium pizzas
            for (OrderItem order : orderItems) {
                if (order.getSize().equalsIgnoreCase("medium")) {
                    mediumPriceSum += order.getPrice();
                    mediumPizzaFound++;
                    if (mediumPizzaFound == 3) {
                        break;
                    }
                }
            }

            // If there are not 3 medium pizzas, assume medium price from the menu
            if (mediumPizzaFound < 3) {
                for (Pizza menuPizza : pizzas) {
                    if (menuPizza.getPriceMedium() != null) {
                        mediumPriceSum += menuPizza.getPriceMedium();
                        mediumPizzaFound++;
                        if (mediumPizzaFound == 3) {
                            break;
                        }
                    }
                }
            }

            // Adjust total cost: Large pizzas will be charged at the medium price
            if (mediumPizzaFound == 3) {
                int largePizzaSum = 0;
                for (OrderItem order : orderItems) {
                    if (order.getSize().equalsIgnoreCase("large")) {
                        largePizzaSum += order.getPrice();
                    }
                }

                // Replace large pizza cost with medium pizza cost if applicable
                total = total - largePizzaSum + mediumPriceSum;
                discountApplied = true;
            }
        }

        // Step 7: If no discount was applied, return the total price without changes
        if (!discountApplied) {
            return total;
        }

        return total;  // Return total after applying all possible discounts
    }

    public static void main(String[] args) {
        // Example usage:

        Pizza margherita = new Pizza();
        margherita.setName("Margherita");
        margherita.setPriceSmall(8);
        margherita.setPriceMedium(10);
        margherita.setPriceLarge(12);

        Pizza pepperoni = new Pizza();
        pepperoni.setName("Pepperoni");
        pepperoni.setPriceSmall(9);
        pepperoni.setPriceMedium(11);
        pepperoni.setPriceLarge(13);

        Pizza[] menu = {margherita, pepperoni};

        OrderItem order1 = new OrderItem();
        order1.setName("Margherita");
        order1.setSize("large");

        OrderItem order2 = new OrderItem();
        order2.setName("Pepperoni");
        order2.setSize("medium");

        OrderItem order3 = new OrderItem();
        order3.setName("Margherita");
        order3.setSize("small");

        OrderItem[] orderItems = {order1, order2, order3};

        DiscountCalc calc = new DiscountCalc();
        int finalTotal = calc.discCalc(menu, orderItems);
        System.out.println("Final Total after discounts: $" + finalTotal);
    }
}
