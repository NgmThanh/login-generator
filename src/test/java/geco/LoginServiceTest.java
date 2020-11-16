package geco;

import org.junit.Test;

import java.util.ArrayList;

public class LoginServiceTest {

    @Test
    public void testLoginExists() {
        String[] listLogin = {"enzo", "axel", "maxou"};
        LoginService loginService = new LoginService(listLogin);

        loginService.loginExists("thanh");
        loginService.loginExists("enzo");

        assert !loginService.findAllLogins().contains("thanh") : "not exists";
        assert loginService.findAllLogins().contains("enzo") : "exist";
    }

    @Test
    public void testAddLogin() {
        String[] listLogin = {"enzo", "axel", "maxou"};
        LoginService loginService = new LoginService(listLogin);

        String loginToAdd1 = "babar";
        String loginToAdd2 = "solel";
        loginService.addLogin(loginToAdd1);

        assert loginService.loginExists(loginToAdd1) : "login not added";
        assert !loginService.loginExists(loginToAdd2) : "login added";
    }

    @Test
    public void fintAddLoginsStartinggWithTest() {
        String[] listLogin = {"enzo", "axel", "maxou", "emily", "emeric"};
        LoginService loginService = new LoginService(listLogin);

        ArrayList<String> tabLoginStart1 = new ArrayList<>();
        ArrayList<String> tabLoginStart2 = new ArrayList<>();

        tabLoginStart1 = (ArrayList<String>) loginService.findAllLoginsStartingWith("e");
        tabLoginStart2 = (ArrayList<String>) loginService.findAllLoginsStartingWith("Z");

        assert tabLoginStart1.contains("enzo") && tabLoginStart1.contains("emily") && tabLoginStart1.contains("emeric") : "not in tab";
        assert tabLoginStart2.isEmpty();
    }
}
