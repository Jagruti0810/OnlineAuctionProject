package view;

import common.InputHandler;
import model.Product;

public class RemoveProduct {
    public Product RemoveProducts() {
        Product product = new Product();
        System.out.println("Enter product id:");
        product.setProductId(InputHandler.takeNumberInput());
        return product;
    }
}

