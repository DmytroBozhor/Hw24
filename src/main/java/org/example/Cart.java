package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private List<Product> cart = new ArrayList<>();
    @Autowired
    private ProductRepository productRepository;

    public void addProduct(int id) {
        cart.add(productRepository.getProductByID(id));
    }

    public void removeProduct(int id) {
        cart.remove(productRepository.getProductByID(id));
    }

    public List<Product> getCart() {
        return cart;
    }
}
