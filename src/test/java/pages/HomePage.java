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

    @FindBy(xpath = "(//a[text()='Home'])[2]")
    public WebElement homeSecNavBarBtn;

    @FindBy(xpath ="(//a[text()='About Us'])[2]")
    public WebElement aboutUsSecNavBtn;

    @FindBy(xpath = "(//a[text()='Services'])[2]" )
    public WebElement servicesSecNavBtn;

    @FindBy(xpath = "(//a[text()='Clients'])[2]")
    public WebElement clientsSecNavBtn;

    @FindBy(xpath = "(//a[text()='Join Us'])[2]")
    public WebElement joinUsSecNavBtn;

    @FindBy(xpath = "(//a[text()='Contact Us'])[2]")
    public WebElement contactUsSecNavBtn;

    @FindBy(xpath = "//div[@class='container clearfix']")
    public WebElement secondaryNavigationBar;

    @FindBy(xpath = "//span[@class='icon icon-interface']")
    public WebElement scrollIntoView;



}
