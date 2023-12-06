import Functional_Interfaces.ProductFilter;
import Shop.Customer;
import Shop.Order;
import Shop.Product;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------------------- Esercizio 1 ----------------------");

        Predicate<Product> isBook = product -> product.getCategory().equals("Books");
        Predicate<Product> priceBook = product -> product.getPrice() > 100;
        ProductFilter bookFilterPrice = products -> products.stream().filter(product -> isBook.test(product) && priceBook.test(product)).toList();

        Customer maria = new Customer("Maria", 3);
        Customer mario = new Customer("Mario", 2);
        Customer chiara = new Customer("Chiara", 5);

        Product book1 = new Product("libro1", "Books", 120);
        Product book2 = new Product("libro2", "Books", 20);
        Product book3 = new Product("libro3", "Books", 140);
        Product book4 = new Product("libro4", "Books", 50);
        Product baby1 = new Product("biberon", "Baby", 30);
        Product baby2 = new Product("ghette", "Baby", 50);
        Product baby3 = new Product("ciuccio", "Baby", 20);

        List<Product> products = Arrays.asList(book1, book2, book3, book4);
        System.out.println(bookFilterPrice.getProducts(products));

        System.out.println("----------------------- Esercizio 2 ----------------------");


        Order oreder1 = new Order("in transito", LocalDate.now(),LocalDate.now().plusDays(7),Arrays.asList(baby1,baby2,baby3,book1), maria);
        Order oreder2 = new Order("inviato", LocalDate.now(),LocalDate.now().plusDays(4),Arrays.asList(book1, book2), mario);
        Order oreder3 = new Order("inviato", LocalDate.now(),LocalDate.now().plusDays(4),Arrays.asList(book1, baby2, baby3), chiara);

        List<Order> orders = Arrays.asList(oreder1, oreder2, oreder3);
        Predicate<Product> isBaby = product -> product.getCategory().equals("Baby");
        Predicate<Order> orderBaby = order -> order.getProducts().stream().anyMatch(isBaby);
        List<Order> ordersWhithBaby = orders.stream().filter(orderBaby).toList();

        System.out.println(ordersWhithBaby.size());
        ordersWhithBaby.forEach(System.out::println);

        System.out.println("----------------------- Esercizio 3 ----------------------");

    }
}