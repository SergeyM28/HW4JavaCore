package ru.mikhailov;

import java.util.ArrayList;

public class OrderProcessor {
    private Customer[]customerArray;
    private Product[]productArray;
    private ArrayList<Order> orders;

    public OrderProcessor(Customer[] customerArray, Product[] productArray) {
        this.customerArray = customerArray;
        this.productArray = productArray;
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order){
        if (order != null) {
            this.orders.add(order);
            System.out.println("Товар " + order.getProduct().getName() + " добавлен");
        }
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void showOrders(){
        for(Order elem : this.orders){
            System.out.println(elem.toString());
        }
    }

    private Customer getCustomerByFio(String fioToFind) throws CustomerException {
        for(Customer elem : this.customerArray){
            if(elem.getFio().equalsIgnoreCase(fioToFind)){
                return elem;
            }
        }throw new CustomerException("Ошибка. Клиент " + fioToFind + " не найден");
    }

    private Product getProductByName(String nameToFind) throws ProductException {
        for(Product elem : this.productArray){
            if(elem.getName().equalsIgnoreCase(nameToFind)){
                return elem;
            }
        }throw new ProductException("Товар " + nameToFind + " не найден");
    }

    public Order purchase(String customer, String product, int amount){
        Order order = null;
        try {
            if (amount > 100 || amount < 1) {
                order = new Order(getCustomerByFio(customer), getProductByName(product), 1);
                throw new AmountException("Неверное количество товара " + product +
                        ". Необходимо указывать от 1 до 100. Вы указали " + amount + ". Добавлена 1 шт. " + product);

            }
            else {
                order = new Order(getCustomerByFio(customer), getProductByName(product), amount);
            }
        }
        catch (CustomerException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException();
        }
        catch (ProductException e){
            System.out.println(e.getMessage());
        }
        catch (AmountException e){
            System.out.println(e.getMessage());
        }
        finally {
            return order;
        }
    }


}
