package com.herokuapp.testsuite;

import com.herokuapp.pages.LoginPage;
import com.herokuapp.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    LoginPage loginPage = new LoginPage();

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        loginPage.enterUserName("tomsmith");
        loginPage.enterpassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage = "Secure Area";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message displayed");

    }
    @Test
    public void verifyTheUsernameErrorMessage() {
        loginPage.enterUserName("tomsmith1");
        loginPage.enterpassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage = "Your username is invalid!\n"+ "×";
        String actualErrorMessage = loginPage.getErrorMessageInvalid();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message displayed");
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        loginPage.enterUserName("tomsmith");
        loginPage.enterpassword("SuperSecretPassword");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage = "Your password is invalid!\n"+ "×";
        String actualErrorMessage = loginPage.getErrorMessageInvalid();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message displayed");
    }
}
