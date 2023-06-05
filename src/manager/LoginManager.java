package manager;

import Service.LoginService;

public class LoginManager {

    private LoginService loginService = new LoginService();

    public void doLogin() {
        loginService.doLogin();
    }
}

