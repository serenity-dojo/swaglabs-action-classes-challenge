package swaglabs.actions.authentication;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;

public class LoginActions extends UIInteractions {
    @Step("Log in to the Swaglabs application as {0}")
    public void withCredentials(String username, String password) {
        openUrl("https://www.saucedemo.com/");
        $("#user-name").sendKeys(username);
        $("#password").sendKeys(password);
        $("#login-button").click();
    }
}
