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

        //------------------ Lista prodotti e utenti -----------------------
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

        Product boy1 = new Product("rasoio", "Boys", 15);
        Product boy2 = new Product("dopobarba", "Boys", 12.3);
        Product boy3 = new Product("boxeur", "Boys", 20.60);

        List<Product> products = Arrays.asList(book1, book2, book3, book4);
        Predicate<Product> isBook = product -> product.getCategory().equals("Books");
        Predicate<Product> priceBook = product -> product.getPrice() > 100;
        List<Product> bookFilterPrice =  products.stream().filter(product -> isBook.test(product) && priceBook.test(product)).toList();

        System.out.println(bookFilterPrice.size());
        bookFilterPrice.forEach(System.out::println);

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

        List<Product> products1 = Arrays.asList(boy1, boy2, boy3, baby1, book2);

        List<Product> discountedBoysProduct = products1.stream().filter(product -> product.getCategory().equals("Boys")).map(product -> new Product(product.getName(), product.getCategory(),(int)(product.getPrice()) * 0.9)).toList();
        System.out.println(products1);
        System.out.println(discountedBoysProduct);

        System.out.println("----------------------- Esercizio 4 ----------------------");

    }
}