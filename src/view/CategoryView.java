package view;

import model.ProductCategory;

import java.util.List;

public class CategoryView {
    public void displayCategory(List<ProductCategory> productCategoryList) {
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("|%-20s|%-20s|\n", "Product Category id", "Category name");
        System.out.println("----------------------------------------------------------------------");
        for (ProductCategory productCategory : productCategoryList) {
            System.out.printf("|%-20s|%-20s|\n", productCategory.getProductCategoryId(), productCategory.getCategoryName());
        }
        System.out.println("-----------------------------------------------------------------------");
    }
}
