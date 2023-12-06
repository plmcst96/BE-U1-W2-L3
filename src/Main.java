
import Shop.Customer;
import Shop.Order;
import Shop.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

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

        System.out.println("----------------------- Esercizio 1 ----------------------");

        List<Product> products = Arrays.asList(book1, book2, book3, book4);
        Predicate<Product> isBook = product -> product.getCategory().equals("Books");
        Predicate<Product> priceBook = product -> product.getPrice() > 100;
        List<Product> bookFilterPrice =  products.stream().filter(product -> isBook.test(product) && priceBook.test(product)).toList();

        System.out.println(bookFilterPrice.size());
        bookFilterPrice.forEach(System.out::println);

        System.out.println("----------------------- Esercizio 2 ----------------------");


        Order oreder1 = new Order("in transito", LocalDate.of(2021, 1, 21),Arrays.asList(baby1,baby2,baby3,book1), maria);
        Order oreder2 = new Order("inviato", LocalDate.of(2020, 1, 1),Arrays.asList(book1, book2), mario);
        Order oreder3 = new Order("inviato", LocalDate.of(2020, 2, 1),Arrays.asList(book1, baby2, baby3), chiara);

        List<Order> orders = Arrays.asList(oreder1, oreder2, oreder3);
  /*    Predicate<Product> isBaby = product -> product.getCategory().equals("Baby");
        Predicate<Order> orderBaby = order -> order.getProducts().stream().anyMatch(isBaby);
        List<Order> ordersWhithBaby = orders.stream().filter(orderBaby).toList(); sintassi più lunga*/

        List<Order> ordersWhithBaby = orders.stream().filter(order -> order.getProducts().stream().anyMatch(product -> product.getCategory().equals("Baby"))).toList();

        System.out.println(ordersWhithBaby.size());
        ordersWhithBaby.forEach(System.out::println);

        System.out.println("----------------------- Esercizio 3 ----------------------");

        List<Product> products1 = Arrays.asList(boy1, boy2, boy3, baby1, book2);

        List<Product> discountedBoysProduct = products1.stream().filter(product -> product.getCategory().equals("Boys")).map(product -> {
            product.setPrice(product.getPrice() * 0.9);
            return product;
        }).toList();
        System.out.println(products1);
        System.out.println(discountedBoysProduct);

        System.out.println("----------------------- Esercizio 4 ----------------------");

        LocalDate startDate = LocalDate.of(2021, 2, 1);
        LocalDate endDate = LocalDate.of(2021, 4, 1);

        List<Order> tier2Orders = orders.stream().filter(order -> order.getCustomer().getTier() == 2
                && order.getOrderDate().isAfter(LocalDate.of(2001, 2, 1))
                && order.getOrderDate().isBefore(LocalDate.of(2021, 4, 1))).toList();

        List<Product> tier2Products = new ArrayList<>();
        tier2Orders.forEach(order -> tier2Products.addAll(order.getProducts()));

        tier2Products.forEach(System.out::println);


    }
}