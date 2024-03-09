package com.bo.medsys.automation.medsys.core.ui.pages.homes;

import com.bo.medsys.automation.medsys.core.ui.pages.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(css = "h6[class]")
    private WebElement titleLabel;

    public HomePage() {
        super();
    }

    public boolean isDisplayed() {
        return action.isElementDisplayed(titleLabel);
    }
}
