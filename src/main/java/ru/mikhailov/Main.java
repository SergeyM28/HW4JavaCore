package ru.mikhailov;

/*
Класс «Эмуляция интернет-магазина».
        1. Написать классы покупатель (ФИО, возраст, телефон), товар (название, цена) и заказ
        (объект покупатель, объект товар, целочисленное количество).

        2. Создать массив покупателей (инициализировать 2 элемента), массив товаров (инициализировать 5 элементов)
        и массив заказов (пустой на 5 элементов).

        >> Вместо массива заказов у меня приветное поле ArrayList<Order> orders в классе OrderProcessor.
        >> Всю логику я помести в этот класс.

        3. Создать статический метод «совершить покупку» со строковыми параметрами, соответствующими полям объекта заказа.
        Метод должен вернуть объект заказа.

        >> У меня это публичный нестатический метод в классе OrderProcessor.

        4. Если в метод передан несуществующий покупатель – метод должен выбросить исключение CustomerException, если
        передан несуществующий товар, метод олжен выбросить исключение ProductException, если было передано отрицательное
        или слишком больше значение количества (например, 100), метод должен выбросить исключение AmountException.
        5. Вызвать метод совершения покупки несколько раз таким образом, чтобы заполнить массив покупок возвращаемыми
        значениями. Обработать исключения следующим образом (в заданном порядке):
        –если был передан неверный товар – вывести в консоль сообщение об ошибке, не совершать данную покупку;
        –если было передано неверное количество – купить товар в количестве 1;
        –если был передан неверный пользователь – завершить работу приложения с исключением.
        6. Вывести в консоль итоговое количество совершённых покупок после выполнения основного кода приложения.
*/
public class Main {
    public static void main(String[] args) {
        Customer[]customerArray = {
                new Customer("Ronald Weasley", 17, "79111111111"),
                new Customer("Hermione Granger", 17, "79222222222")
        };

        Product[]productArray = {
                new Product("Broom", 100),
                new Product("Wand", 200),
                new Product("Owl", 300),
                new Product("Felix Felicis", 1000),
                new Product("Time-Turner", 2000)
        };

        OrderProcessor orderProcessor = new OrderProcessor(customerArray, productArray);
        orderProcessor.addOrder(orderProcessor.purchase("Ronald Weasley", "Broom", 10));
        orderProcessor.addOrder(orderProcessor.purchase("Hermione Granger", "Time-Turner", 1));

        // Неверное количество
        orderProcessor.addOrder(orderProcessor.purchase("Ronald Weasley", "Owl", 101));

        // Неверный товар
        orderProcessor.addOrder(orderProcessor.purchase("Hermione Granger", "Nimbus3000", 1));

        // Неверный товар и количество
        orderProcessor.addOrder(orderProcessor.purchase("Hermione Granger", "Nimbus3000", 3000));

        System.out.println("Содержимое корзины: ");
        orderProcessor.showOrders();

        // Неверный клиент. Программа вылетит по Runtime Exception
        orderProcessor.addOrder(orderProcessor.purchase("Draco Malfoy", "Felix Felicis", 1));
    }
}