package view;

import common.InputHandler;
import model.Product;

import java.util.List;

public class AddProduct {
    //addProductDetails
    public Product addProductInfomation() {
        Product product = new Product();
        System.out.println("Enter Product name:");
        product.setProductName(InputHandler.takeStringInput());
        System.out.println("Enter Product description:");
        product.setProductDescription(InputHandler.takeStringInput());
        return product;
    }

    public void displayProducts(List<Product> products) {
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.printf("|%-20s|%-20s|%-20s|\n", "Product id", "Product name", "Product description");
        System.out.println("--------------------------------------------------------------------------------------------");
        for (Product product : products) {
            System.out.printf("|%-20s|%-20s|%-20s|\n", product.getProductId(), product.getProductName(), product.getProductDescription());
        }
        System.out.println("--------------------------------------------------------------------------------------------");
    }
}
