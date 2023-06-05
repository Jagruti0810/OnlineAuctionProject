package Service;

import common.InputHandler;
import common.Session;
import dao.UserDao;
import exception.DaoException;
import manager.RoleManager;

import model.User;
import view.LoginView;

public class LoginService {

    private UserDao userDao = new UserDao();
    private LoginView loginView = new LoginView();

    public void doLogin() {
        User user = loginView.getLoginCredentials();
        try {
            User user1 = userDao.getUserCredentials(user.getEmail(), user.getPassword());
            if (user1 == null) {
                loginView.displayLoginErrorMessage("Login failed!!!");
                loginView.getLoginCredentials();
            }
            if (checkAccountVerification(user1)) {
                System.out.println("Login Successful. Welcome, " + user1.getUsername() + "!");
            } else {
                //Max 3
                loginView.displayLoginErrorMessage("Verification code is wrong");
            }
            Session.setCurrentUser(user1);
            RoleManager roleManager = new RoleManager();
            roleManager.checkUserRole(user1);

        } catch (DaoException ex) {
            ex.printStackTrace();
        }
    }

    public boolean checkAccountVerification(User user) throws DaoException {
        if (!user.isVerified()) {
            String otp;
            System.out.print("Your account is not verified. Please enter the verification code: ");
            otp = InputHandler.takeStringInput();
            if (otp.equals(user.getVerificationCode())) {
                userDao.checkUserVerified(true, user.getEmail());
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
}