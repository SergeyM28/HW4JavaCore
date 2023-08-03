package ru.mikhailov;

public class Customer {
    private String fio;
    private int age;
    private String phoneNumber;

    public String getFio() {
        return fio;
    }

    public Customer(String fio, int age, String phoneNumber) {
        this.fio = fio;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }
}
