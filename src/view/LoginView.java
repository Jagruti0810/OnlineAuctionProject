package view;

import common.InputHandler;
import model.User;
import validation.Validation;

public class LoginView {
    public User getLoginCredentials() {
        boolean isEmailValid;
        User user = new User();
        do {
            System.out.println("Enter emailId:");
            user.setEmail(InputHandler.takeStringInput());
            isEmailValid = Validation.isEmailValid(user.getEmail());
            if (!isEmailValid) {
                System.out.println("Invalid mail");
            } else {
                break;
            }
        } while (!isEmailValid);
        System.out.println("Enter New Password:");
        user.setPassword(InputHandler.takeStringInput());
        return user;
    }

    public void displayLoginSuccessMessage(String message) {
        System.out.println("Login Successfully!!");
    }

    public void displayLoginErrorMessage(String message) {
        System.out.println("Error" + message);
    }
}
