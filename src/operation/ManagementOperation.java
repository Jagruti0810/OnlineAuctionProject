package operation;

import common.Constant;
import common.InputHandler;
import exception.DaoException;
import view.AppMenu;

public class ManagementOperation {
    public static void getDeailsAndSelect() throws DaoException {
        int ch3;
        do {
            AppMenu appMenu = new AppMenu();
            appMenu.displayMainMenuAndSelect();
            ch3 = InputHandler.takeNumberInput();
            switch (ch3) {
                case Constant.VIEW_PRODUCT_INFO:
                    ProductMenuOperation menuchoice = new ProductMenuOperation();
                    menuchoice.getProductDetails();
                    break;
                case Constant.VIEW_AUCTION_DEATILS:
                    AuctionOperation viewAuctionMenuAndSelect = new AuctionOperation();
                    viewAuctionMenuAndSelect.getAuctionDetails();
                    break;
                case Constant.MENU_EXIT:
                    System.exit(0);
                    break;
            }
        } while (ch3 < 4);
    }
}
