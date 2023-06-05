package operation;

import common.Constant;
import common.InputHandler;
import exception.DaoException;
import manager.AuctionManager;
import view.AppMenu;

public class AuctionOperation {
    public static int getAuctionDetails() throws DaoException {
        int choice;
        AuctionManager auctionManager = new AuctionManager();
        do {
            AppMenu appMenu = new AppMenu();
            appMenu.displayAuctionMenu();
            choice = InputHandler.takeNumberInput();
            switch (choice) {
                case Constant.MENU_ADD_AUCTION:
                    auctionManager.addAuction();
                    break;
                case Constant.MENU_VIEW_AUCTION:
                    System.out.println("View Auction Details");
                    auctionManager.viewAuctionDetails();
                    break;
                case Constant.MENU_EDIT_AUCTION:
                    break;
                case Constant.MENU_REMOVE_AUCTION:
                    break;
                case Constant.EXIT:
                    System.exit(0);
                    break;
            }
        } while (choice < 6);
        return choice;
    }
}
