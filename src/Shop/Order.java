package Shop;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Order{
    private final long id;
    private String status;

    private LocalDate orderDate;
    private LocalDate deloveryDate;
    private List<Product> products;

    private Customer customer;

    public Order(String status, LocalDate orderDate, LocalDate deloveryDate, List<Product> products, Customer customer) {
        Random rndm = new Random();
        this.id = rndm.nextLong(10);
        this.status = status;
        this.orderDate = orderDate;
        this.deloveryDate = deloveryDate;
        this.products = products;
        this.customer = customer;
    }

    public long getId() {
        return id;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getDeloveryDate() {
        return deloveryDate;
    }

    public void setDeloveryDate(LocalDate deloveryDate) {
        this.deloveryDate = deloveryDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deloveryDate=" + deloveryDate +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }
}
