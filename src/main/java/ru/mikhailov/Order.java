package ru.mikhailov;

public class Order {
    private Customer customer;
    private Product product;
    private int amount;

    public Order(Customer customer, Product product, int amount) {
        this.customer = customer;
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer.getFio() +
                ", product=" + product.getName() +
                ", amount=" + amount +
                '}';
    }
}
