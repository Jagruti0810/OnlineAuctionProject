package view;

import common.InputHandler;
import model.Product;

public class EditProduct {
    public Product editDetails() {
        Product product = new Product();
        System.out.println("Enter product id:");
        product.setProductId(InputHandler.takeNumberInput());
        AddProduct addProduct = new AddProduct();
        addProduct.addProductInfomation();
        return product;
    }
}
