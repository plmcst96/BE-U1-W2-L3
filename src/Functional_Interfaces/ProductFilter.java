package Functional_Interfaces;

import Shop.Product;

import java.util.List;

public interface ProductFilter {
    public List<Product> getProducts(List<Product> products);
}
