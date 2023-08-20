package org.example;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> productList;

    @PostConstruct
    private void doMyInit() {
        Product product1 = new Product(1, "Something1", 20);
        Product product2 = new Product(2, "Something2", 50);
        Product product3 = new Product(3, "Something3", 100);

        this.productList = List.of(product1, product2, product3);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Product getProductByID(int id) {
        return productList.stream().filter(product -> product.getId() == id).toList().get(0);
    }
}
