package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

/**
 * LoginTest - Selenium TestNG tests for the Login Feature.
 *
 * Spec Traceability:
 *   AUTH-001 -> TC-LOGIN-001 -> validLoginTest
 *   AUTH-002 -> TC-LOGIN-002 -> invalidPasswordTest
 *   AUTH-003 -> TC-LOGIN-003 -> blankCredentialsValidationTest
 *
 * Spec Reference: specs/001-login/spec.md
 * Test Matrix:    examples/login-test-matrix.md
 * Target App:     https://the-internet.herokuapp.com/login
 */
public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void setUpLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.navigateTo();
    }

    /**
     * TC-LOGIN-001 | AUTH-001
     * Scenario: Successful login with valid credentials
     * Expected: User is redirected to secure area with success message
     */
    @Test(description = "TC-LOGIN-001: Valid login redirects to secure area")
    public void validLoginTest() {
        loginPage.loginAs("tomsmith", "SuperSecretPassword!");

        Assert.assertTrue(
            loginPage.isOnSecureArea(),
            "User should be redirected to secure area after valid login"
        );

        String flashMsg = loginPage.getFlashMessage();
        Assert.assertTrue(
            flashMsg.contains("You logged into a secure area!"),
            "Flash message should confirm successful login. Got: " + flashMsg
        );
    }

    /**
     * TC-LOGIN-002 | AUTH-002
     * Scenario: Login fails with invalid password
     * Expected: Error message shown, user stays on login page
     */
    @Test(description = "TC-LOGIN-002: Invalid password shows error message")
    public void invalidPasswordTest() {
        loginPage.loginAs("tomsmith", "WrongPassword");

        Assert.assertTrue(
            loginPage.isOnLoginPage(),
            "User should remain on login page after invalid credentials"
        );

        String flashMsg = loginPage.getFlashMessage();
        Assert.assertTrue(
            flashMsg.contains("Your password is invalid!"),
            "Flash message should show password error. Got: " + flashMsg
        );
    }

    /**
     * TC-LOGIN-003 | AUTH-003
     * Scenario: Login with blank credentials shows validation/error
     * Expected: Error or validation message shown, user not logged in
     */
    @Test(description = "TC-LOGIN-003: Blank credentials show validation error")
    public void blankCredentialsValidationTest() {
        loginPage.loginAs("", "");

        Assert.assertTrue(
            loginPage.isOnLoginPage(),
            "User should remain on login page after blank credentials"
        );

        String flashMsg = loginPage.getFlashMessage();
        Assert.assertFalse(
            flashMsg.isEmpty(),
            "An error/validation message should be displayed. Got empty string."
        );
    }
}
