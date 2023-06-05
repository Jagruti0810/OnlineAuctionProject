package operation;

import common.Constant;
import common.InputHandler;
import exception.DaoException;
import manager.ProductManager;
import view.*;

public class ProductMenuOperation {
    public static int getProductDetails() throws DaoException {
        int ch1;
        ProductManager productManager = new ProductManager();
        do {
            AppMenu appMenu = new AppMenu();
            appMenu.displayProductMenu();
            ch1 = InputHandler.takeNumberInput();
            switch (ch1) {
                case Constant.MENU_ADD_PRODUCT:
                    productManager.createProduct();
                    break;
                case Constant.MENU_VIEW_PRODUCT:
                    System.out.println("View Products Details");
                    ProductViewOperation viewMenuChoice = new ProductViewOperation();
                    viewMenuChoice.viewProductDetails();
                    break;
                case Constant.MENU_EDIT_PRODUCT:
                    productManager.editProductDetails();
                    break;
                case Constant.MENU_REMOVE_PRODUCT:
                    productManager.deleteProduct();
                    break;
                case Constant.EXIT:
                    System.exit(0);
                    break;
            }
        } while (ch1 < 7);
        return ch1;
    }
}
