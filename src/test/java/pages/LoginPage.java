package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * LoginPage - Page Object Model for the Login feature.
 *
 * Spec Reference: specs/001-login/spec.md
 * Acceptance Criteria Mapped:
 *   AUTH-001: Valid credentials -> success redirect
 *   AUTH-002: Invalid password  -> error flash message
 *   AUTH-003: Blank credentials -> error/validation message
 *
 * Target App: https://the-internet.herokuapp.com/login
 */
public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // --- Locators ---
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton   = By.cssSelector("button[type='submit']");
    private final By flashMessage  = By.id("flash");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /** Navigate directly to the login page */
    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    /**
     * Perform login action.
     * @param username the username to enter
     * @param password the password to enter
     */
    public void loginAs(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    /** Get flash message text after login attempt */
    public String getFlashMessage() {
        WebElement flash = wait.until(
            ExpectedConditions.visibilityOfElementLocated(flashMessage)
        );
        return flash.getText();
    }

    /** Check if user was redirected to the secure area (successful login) */
    public boolean isOnSecureArea() {
        return driver.getCurrentUrl().contains("/secure");
    }

    /** Check if user is still on login page (failed login) */
    public boolean isOnLoginPage() {
        return driver.getCurrentUrl().contains("/login");
    }
}
