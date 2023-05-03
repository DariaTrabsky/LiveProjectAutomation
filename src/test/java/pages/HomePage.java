package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class HomePage {
    public HomePage() { PageFactory.initElements(BrowserUtils.getDriver(), this);}

    @FindBy(xpath = "//i[text()='10090 Main Street']")
    public WebElement addressLine1;

    @FindBy(xpath = "//strong[text()='Fairfax, VA, USA']")
    public WebElement addressLine2;

    @FindBy(xpath ="//strong[text()='+1 703-831-3227']")
    public WebElement phoneNumber;

}
