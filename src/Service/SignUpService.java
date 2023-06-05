package Service;

import common.InputHandler;
import model.User;
import validation.Validation;

//CreateUser, getSingUpInfo, getSignDetailFromUser
public class SignUpService {

    //CreateUser, getSingUpInfo, getSignDetailFromUser
    public User getSignUpInfo() {
        User user = new User();
        boolean isEmailValid;
        System.out.println("Enter Username:");
        user.setUsername(InputHandler.takeStringInput());
        int maxAttempts = 3;
        int attempts = 0;
        while (attempts < maxAttempts) {
            System.out.println("Enter Mobile no:");
            user.setMobileNo(InputHandler.takeStringInput(true));
            if (Validation.isMobileValid(user.getMobileNo())) {
                break;
            }
            attempts++;
            if (!Validation.isMobileValid(user.getMobileNo())) {
                System.out.println("Invalid Mobile no");
            }
        }

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

        System.out.println("Enter address:");
        user.setAddress(InputHandler.takeStringInput());

        System.out.println("Enter Password:");
        user.setPassword(InputHandler.takeStringInput());

        System.out.println("Enter your role [2. Seller, 3. Bidder]:");
        user.setRoleId(InputHandler.takeNumberInput());
        return user;
    }

    public void displaySignUpSuccessMessage() {
        System.out.println("Your account has been registered to the system!");
    }

    public void displaySignUpErrorMessage(String message) {
        System.out.println("Error" + message);
    }
}



