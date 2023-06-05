package view;

//import common.Constant;
//import common.InputHandler;
//import dao.UserDao;
//import exception.DaoException;
//import model.User;
//
//public class RoleView {
//    public void roleView(String email) throws DaoException {
//        User user = new User();
//        UserDao userDao = new UserDao();
//        int choice = InputHandler.takeNumberInput();
//        switch (choice) {
//            case Constant.LOG_IN_AS_ADMIN:
//                userDao.UpdateUserByRole(user.setRoleId(1), email);
//            case Constant.LOG_IN_AS_SELLER:
//                userDao.UpdateUserByRole(user.setRoleId(2), email);
//            case Constant.LOG_IN_AS_BUYER:
//                userDao.UpdateUserByRole(user.setRoleId(3), email);
//        }
//    }
//}
