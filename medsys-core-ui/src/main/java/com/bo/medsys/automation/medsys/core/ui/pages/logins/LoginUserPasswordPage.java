package com.bo.medsys.automation.medsys.core.ui.pages.logins;

import com.bo.medsys.automation.medsys.core.ui.pages.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginUserPasswordPage extends BasePage implements LoginPage {
    @FindBy(css = "input[id*=':r']")
    private WebElement userNameTxt;

    @FindBy(css = "input[type='password']")
    private WebElement passwordTxt;

    @FindBy(css = "button[type='submit']")
    private WebElement loginBtn;

    @FindBy(css = "p[class*='MuiFormHelperText-contained']")
    private WebElement errorMessageLabel;

    /**
     * {@inheritDoc}
     */
    @Override
    public void loginUserInPortal() {
        webDriver.navigate().to(environmentManager.getLoginUrl());
        action.setValue(userNameTxt, environmentManager.getUsername());
        action.setValue(passwordTxt, environmentManager.getPassword());
        action.click(loginBtn);
    }

    public String getErrorMessage() {
        return action.getText(errorMessageLabel);
    }
}
