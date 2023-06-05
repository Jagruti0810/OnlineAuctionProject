package operation;

import common.Constant;
import common.InputHandler;
import exception.DaoException;
import manager.ProductManager;
import view.AppMenu;

public class ProductViewOperation {
    public static void viewProductDetails() throws DaoException {
        int ch2;
        ProductManager productManager = new ProductManager();
        do {
            AppMenu appMenu = new AppMenu();
            appMenu.displayAllProductDetails();
            ch2 = InputHandler.takeNumberInput();
            switch (ch2) {
                case Constant.VIEW_ALL_PRODUCT_ALPHABETIC:
                    productManager.listOfProductsAscending();
                    break;
                case Constant.VIEW_ALL_PRODUCT_LATESTADD:
                    productManager.listOfProductsDescending();
                    break;
            }
        } while (ch2 < 4);
    }
}
