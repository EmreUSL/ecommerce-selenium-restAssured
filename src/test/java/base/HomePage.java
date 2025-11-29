package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Sign Up
    private final By homeSignUpButton = By.id("signin2");
    private final By signInModal = By.id("signInModalLabel");
    private final By signUsername = By.id("sign-username");
    private final By signPassword = By.id("sign-password");
    private final By signUpButton = By.xpath("//button[contains(text(),\"Sign up\")]");

    //Log In
    private final By homeLogInButton = By.id("login2");
    private final By logInModal = By.id("logInModalLabel");
    private final By logInUsername = By.id("loginusername");
    private final By logInPassword = By.id("loginpassword");
    private final By logInButton = By.xpath("//button[contains(text(),\"Log in\")]");

    //Sign Up

    public void clickSignUpButton() {
        click(homeSignUpButton);
    }

    public boolean isSignUpModalDisplayed() {
        return isDisplayed(signInModal);
    }

    public void setUserName(String value) {
        sendText(signUsername, value);
    }

    public void setPassword(String value) {
        sendText(signPassword, value);
    }

    public void clickSignButton() {
        click(signUpButton);
    }

    //Log in

    public void clickLogInButton() {
        click(homeLogInButton);
    }

    public boolean isLogInModalDisplayed() {
        return isDisplayed(logInModal);
    }

    public void setLoginUsername(String value) {
        sendText(logInUsername, value);
    }

    public void setLoginPassword(String value) {
        sendText(logInPassword, value);
    }

    public void clickButton() {
        click(logInButton);
    }








}
