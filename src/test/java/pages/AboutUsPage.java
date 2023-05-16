package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class AboutUsPage {
    public AboutUsPage() {

        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }

    @FindBy(xpath = "//h2[text()='Why Choose Us']")
    public WebElement aboutUsSection;

    @FindBy(xpath = "//h3[text()='On Time Services']/following-sibling::div[1]")
    public WebElement onTimeServicesText;

    @FindBy(xpath = "//h3[text()='Experienced Team']/following-sibling::div[1]")
    public WebElement experiencedTeamText;

    @FindBy(xpath = "//h3[text()='Good Track Records']/following-sibling::div[1]")
    public WebElement goodTrackRecordsText;

    @FindBy(xpath = "//a[text()='Our Services']")
    public WebElement OurServicesBtn;

    @FindBy(xpath = "//a[text()='About Us']")
    public WebElement aboutUsNavBtn;

    @FindBy(xpath = "//h2[text()='Welcome to Advance Systems LLC.']")
    public WebElement pageHeader;

    @FindBy(xpath = "//h4[text()='Kuba Z']")
    public WebElement nameOfPerson;

    @FindBy(xpath = "//div[text()='CEO & Founder']")
    public WebElement titleOfPerson;

    @FindBy(xpath = "//h2[text()='Meet Our Experts']")
    public WebElement employeeSHeader;

    @FindBy(xpath = "/html/body/div[1]/section[5]/div/div[2]/div[1]/div/div[1]/img")
    public WebElement founderPic;
    @FindBy(xpath = "//div[text()='Founder']")
    public WebElement founderTitle;
    @FindBy(xpath = "/html/body/div[1]/section[5]/div/div[2]/div[1]/div/div[2]/ul/li[1]/a/span")
    public List<WebElement> socialMedia;

    @FindBy(css = "")
    public WebElement facebookLink;

    @FindBy(xpath = "(//span)[16]")
    public WebElement twitterLink;

    @FindBy(xpath = "(//span)[17]")
    public WebElement skypeLink;

    @FindBy(xpath = "(//span)[18]")
    public WebElement linkedinLink;

    @FindBy(xpath = "//div[text()='Great explorer of the truth, the ']")
    public WebElement founderQuoteText;
    @FindBy(xpath = "//div[@class='services-block-five col-lg-3 col-md-6 col-sm-12']")
    public List<WebElement> whyChooseUsSHeader;

    @FindBy(xpath = "//h1[text()='We are Recruitment Experts']")
    public WebElement WeAreRecruitmentExpertsText;

    @FindBy(xpath = "//h3[text()='On Time Services']")
    public WebElement onTimeServicesHeader;

    @FindBy(xpath = "//h3[text()='Experienced Team']")
    public WebElement experiencedTeamHeader;

    @FindBy(xpath = "//h3[text()='Good Track Records']")
    public WebElement goodTrackRecordsHeader;

}

