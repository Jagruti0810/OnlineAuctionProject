package manager;

import common.InputHandler;
import common.Session;
import dao.CategoryDao;
import dao.ProductDao;
import exception.DaoException;
import model.*;
import view.*;

import java.util.List;

public class ProductManager {
    private ProductDao productDao = new ProductDao();
    private ProductCategoryManager productCategoryManager = new ProductCategoryManager();
    private AddProduct addProduct = new AddProduct();
    private Product product = new Product();

    //addNewProduct,
    public void createProduct() throws DaoException {
        product = addProduct.addProductInfomation();
        CategoryDao categoryDao = new CategoryDao();
        List<ProductCategory> productCategoryList = categoryDao.showCategory();
        CategoryView categoryView = new CategoryView();
        categoryView.displayCategory(productCategoryList);
        System.out.println("Enter product category id");
        product.setProductCategoryId(InputHandler.takeNumberInput());
        System.out.println("Product added successfully");
        productDao.addProductDetails(product, Session.getCurrentUser().getUserId());
    }

    //updateProductInfo,
    public void editProductDetails() throws DaoException {
        System.out.println("Update product");
        List<Product> products = productDao.showProducts(Session.getCurrentUser().getUserId());
        addProduct.displayProducts(products);
        EditProduct editProduct = new EditProduct();
        product = editProduct.editDetails();
        productDao.editProductDetails(product);
        System.out.println("Product edited successfully");
    }

    public void deleteProduct() throws DaoException {
        System.out.println("Delete product");
        List<Product> products = productDao.showProducts(Session.getCurrentUser().getUserId());
        addProduct.displayProducts(products);
        RemoveProduct removeProduct = new RemoveProduct();
        product = removeProduct.RemoveProducts();
        productDao.removeProduct(product);
        System.out.println("Product deleted successfully");
    }

    //    public void listOfProducts() {
//        try {
//            List<Product> products = productDao.fetchRecordsFromDatabase();
//            AddProduct addProduct = new AddProduct();
//            addProduct.displayProducts(products);
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }
//    }
    public void listOfProductsAscending() throws DaoException {
        List<Product> products = productDao.showProducts(Session.getCurrentUser().getUserId());
        productCategoryManager.productViewAscending(products);
        addProduct.displayProducts(products);
    }

    public void listOfProductsDescending() throws DaoException {
        List<Product> products = productDao.showProducts(Session.getCurrentUser().getUserId());
        productCategoryManager.productViewDescending(products);
        addProduct.displayProducts(products);
    }
}
