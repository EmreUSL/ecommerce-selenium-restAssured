package base;

import core.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage{

    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Sign Up
    private By homeSingUpButton = By.id("signin2");
    private By signInModal = By.id("signInModalLabel");
    private By signUsername = By.id("sign-username");
    private By signPassword = By.id("sign-password");
    private By signUpButton = By.xpath("//button[contains(text(),\"Sign up\")]");

    //Log In
    private By homeLogInButton = By.id("login2");
    private By logInModal = By.id("logInModalLabel");
    private By logInUsername = By.id("loginusername");
    private By logInPassword = By.id("loginpassword");
    private By logInButton = By.xpath("//button[contains(text(),\"Log in\")]");

    public void clickSignUpButton() {
        click(homeSingUpButton);
    }

    public boolean isSignUpModalDisplayed() {
        return WaitUtil.waitForVisible(signInModal).isDisplayed();
    }

    public void setUserName(String value) {
        click(signUsername);
        sendText(signUsername, value);
    }

    public void setPassword(String value) {
        click(signPassword);
        sendText(signPassword, value);
    }

    public void clickSignInButton() {
        click(signUpButton);
    }






}
