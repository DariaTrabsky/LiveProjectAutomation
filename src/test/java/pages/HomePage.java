package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }

    @FindBy(xpath = "//i[text()='10090 Main Street']")
    public WebElement addressLine1;

    @FindBy(xpath = "//strong[text()='Fairfax, VA, USA']")
    public WebElement addressLine2;

    @FindBy(xpath ="//strong[text()='+1 703-831-3227']")
    public WebElement phoneNumber;

    @FindBy(xpath =" //div[@class='header-top-one']//div[@class='container']")
    public WebElement navBar;

    @FindBy(xpath = "//a[text()='Get Support']")
    public WebElement getSupportBtn;

    @FindBy(xpath = "//a[text()='Job Career']")
    public WebElement jobCareerBtn;
    @FindBy(xpath = "//a[text()='Feedback']")
    public WebElement feedbackBtn;
    @FindBy(xpath = "//a[contains(text(),'English')]")
    public WebElement englishNavBtn;

    @FindBy(xpath = "//a[text()='English']")
    public WebElement englishBtn;
    @FindBy(xpath = "//a[text()='Spanish']")
    public WebElement spanishBtn;
    @FindBy(xpath = "//a[text()='French']")
    public WebElement frenchBtn;

    @FindBy(xpath = "//a[text()='Join Now']")
    public WebElement joinNowBtn;

    @FindBy(xpath = "//span[@class='fa fa-facebook']")
    public WebElement facebookBtn;

    @FindBy(xpath = "//span[@class='fa fa-twitter']")
    public WebElement twitterBtn;

    @FindBy(xpath = "//a[@target='_blank']//span[@class='fa fa-instagram']")
    public WebElement instagramBtn;

    @FindBy(xpath = "//span[@class='fa fa-linkedin']")
    public WebElement linkedin;

}
