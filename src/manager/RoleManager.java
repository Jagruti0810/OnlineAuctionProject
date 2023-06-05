package manager;

import common.Session;
import exception.DaoException;
import model.User;
import operation.ManagementOperation;
import operation.ProductViewOperation;

public class RoleManager {

    public void checkUserRole(User user1) throws DaoException {
        if (Session.getCurrentUser().getRoleId() == 1) {
            System.out.println("Role is Admin");
        } else if (Session.getCurrentUser().getRoleId() == 2) {
            System.out.println("Role is Seller");
            ManagementOperation.getDeailsAndSelect();
        } else if (Session.getCurrentUser().getRoleId() == 3) {
            System.out.println("Role is Buyer");
            ProductViewOperation.viewProductDetails();
        }
    }
}
