import common.Constant;
import exception.DaoException;
import manager.LoginManager;
import manager.SignUpManager;
import view.AppMenu;

public class OnlineAuction {
    static {
        System.out.println("-------- Welcome to Online Auction --------");
    }

    public static void main(String[] args) throws DaoException {
        int ch = AppMenu.displayMainMenu();
        switch (ch) {
            case Constant.MENU_SIGNUP:
                SignUpManager signUpManager = new SignUpManager();
                signUpManager.doSignUp();
                break;
            case Constant.MENU_LOGIN:
                LoginManager loginManager = new LoginManager();
                loginManager.doLogin();
                break;
            case Constant.MENU_EXIT:
                System.exit(0);
                break;
            default:
                System.out.println("Unexpected value" + ch);
                main(null);
                break;
        }
    }
}




