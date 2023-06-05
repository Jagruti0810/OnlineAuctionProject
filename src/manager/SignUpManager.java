package manager;

import common.SendEmailToUser;
import dao.UserDao;
import exception.DaoException;
import model.User;
import common.Utility;
import Service.SignUpService;

public class SignUpManager {
    private SignUpService signUpService = new SignUpService();
    private UserDao userDao = new UserDao();
    private SendEmailToUser sendEmailToUser = new SendEmailToUser();

    public void doSignUp() throws DaoException {
        Utility generateNumber = new Utility();
        User user = signUpService.getSignUpInfo();
        String verficationCode = generateNumber.generateVerificationCode();
        user.setVerificationCode(verficationCode);
        userDao.addUserDetails(user);
        sendMail(user);
        signUpService.displaySignUpSuccessMessage();
    }

    private void sendMail(User user) {
        StringBuilder mailContent = new StringBuilder();
        mailContent.append("<H1>")
                .append("Hi, ").append(user.getUsername())
                .append("</H1>")
                .append("Your verification code :").append(user.getVerificationCode());
        sendEmailToUser.sendMail(user.getEmail(), "Online Auction: Account verification code", mailContent.toString());
    }
}
