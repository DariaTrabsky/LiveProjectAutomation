package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class ContactPage {
    public ContactPage(){
        PageFactory.initElements(BrowserUtils.getDriver(),this);
    }

    @FindBy(xpath = "//input[@placeholder='Your Name*']")
    public WebElement yourNameInputFiled;

    @FindBy(xpath = "//input[@placeholder='Phone Number *']")
    public WebElement phoneNumberInputFiled;

    @FindBy(xpath = "//textarea[@placeholder='Your Message...']")
    public WebElement yourMessageInputFiled;

    @FindBy(xpath = "//span[@id='ui-id-1-button']")
    public WebElement serviceOption;

    @FindBy(xpath = "//button[text()='Submit Now']")
    public WebElement submitBtn;
}
