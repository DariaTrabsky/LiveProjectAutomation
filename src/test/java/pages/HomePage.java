package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.Map;

public class HomePage {
    public HomePage() { PageFactory.initElements(BrowserUtils.getDriver(), this);}

    @FindBy(xpath = "//i[text()='10090 Main Street']")
    public WebElement addressLine1;

    @FindBy(xpath = "//strong[text()='Fairfax, VA, USA']")
    public WebElement addressLine2;

    @FindBy(xpath ="//strong[text()='+1 703-831-3227']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//h2[text()='A bright career is']")
    public WebElement homePageFHeader;

    @FindBy(xpath = "//h2[text()='Think Big.']")
    public WebElement homePageSHeader;

    @FindBy(xpath = "//div[text()='Our Career Network will enhance your job search and']")
    public WebElement homePageDescription;

    @FindBy(xpath = "//a[text()='Read More']")
    public WebElement homePageReadMoreButton;

    @FindBy(xpath = "/html/body/div[1]/header/div[2]/div/div/div[1]/div/a/img")
    public WebElement header;
}
