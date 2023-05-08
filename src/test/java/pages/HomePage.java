package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }

    @FindBy(xpath = "//i[text()='10090 Main Street']")
    public WebElement addressLine1;

    @FindBy(xpath = "//strong[text()='Fairfax, VA, USA']")
    public WebElement addressLine2;

    @FindBy(xpath = "//strong[text()='+1 703-831-3217']")
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



    @FindBy(xpath = " //div[@class='header-top-one']//div[@class='container']")
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

    @FindBy(xpath = "//div[@class='socail-icon-area']//a")
    public List <WebElement> socialMediaButtons;

    @FindBy(xpath = "//li/a/i[@class='fa fa-facebook-square']")
    public WebElement facebookBtn;
    @FindBy(xpath = "//li/a/i[@class='fa fa-twitter-square']")
    public WebElement twitterBtn;
    @FindBy(xpath = "//li/a/i[@class='fa fa-instagram']")
    public WebElement instagramBtn;
    @FindBy(xpath = "//li/a/i[@class='fa fa-linkedin-square']")
    public WebElement linkedinBtn;

    @FindBy(xpath = "//span[@class='fa fa-facebook']")
    public WebElement facebookFtBtn;

    @FindBy(xpath = "//span[@class='fa fa-twitter']")
    public WebElement twitterFtBtn;

    @FindBy(xpath = "//a[@target='_blank']//span[@class='fa fa-instagram']")
    public WebElement instagramFtBtn;

    @FindBy(xpath = "//span[@class='fa fa-linkedin']")
    public WebElement linkedinFtBtn;

    @FindBy(xpath = "//h2[.='Words from our Clients']")
    public WebElement testimonialsHeader;

    @FindBy(xpath = "//section[@class='testimonial-section sp-one parallax-one']//div[@class='text']")
    public List<WebElement> testimonialsMsg;

    @FindBy(xpath = "//section[@class='testimonial-section sp-one parallax-one']//h3")
    public List<WebElement> testimonialsName;

    @FindBy(xpath = "//section[@class='testimonial-section sp-one parallax-one']//div[@class='designation']")
    public List<WebElement> testimonialsState;

    @FindBy(xpath = "//span[@class='right_arrow icon-arrows']")
    public WebElement testimonialsArrow;

    @FindBy(xpath = "//div[@class='owl-item active']//div[@class='thumb-item']")
    public WebElement testimonialsActivePerson;

    @FindBy(xpath = "(//div[@class='owl-stage'])[3]")
    public WebElement listOfCompanies;

    @FindBy(xpath = "//div[@class='six-item-carousel owl-carousel owl-theme owl-dot-none owl-nav-none owl-loaded owl-drag']")
    public WebElement listOfCompanies2;
    @FindBy(xpath = "//h3[text()='Newsletter']/parent::div/div/form/div/input[@placeholder]")
    public WebElement emailPlaceholderFt;

    @FindBy(xpath = "//span[@class='icon fa fa-arrow-up']")
    public WebElement moveToTopBtn;

    @FindBy(xpath = "//div[.='Looking for a dream job?']")
    public WebElement lookingForJob;


}
