package com.herokuapp.pages;

import com.herokuapp.utility.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {
    By usernameField = By.xpath("//input[@id='username']");//Find username and enter the username
    By passwordField = By.xpath("//input[@id='password']");//Find password and enter the password
    By loginButton = By.xpath("//i[contains(text(),'Login')]");//Find Login Button and Click on Login Button
    By verifyText = By.xpath("//body[1]/div[2]/div[1]/div[1]/h2[1]");////Find the Secure Area text element and get the text
    By invalidVerifyText = By.xpath("//div[@id='flash']");////Validate actual and expected message

    public void enterUserName(String username){
        sendTextToElement(usernameField,username);
    }
    public void enterpassword(String password){
        sendTextToElement(passwordField,password);
    }
    public void clickOnLoginButton(){
        clickOnElement(loginButton);
    }
    public String getErrorMessage(){
        return getTextFromElement(verifyText);
    }
    public String getErrorMessageInvalid(){
        return getTextFromElement(invalidVerifyText);
    }
}
