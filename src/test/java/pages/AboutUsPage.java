package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

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

    @FindBy(xpath = "//h1[text()='We are Recruitment Experts']")
    public WebElement WeAreRecruitmentExpertsText;

    @FindBy(xpath = "//h3[text()='On Time Services']")
    public WebElement onTimeServicesHeader;

    @FindBy(xpath = "//h3[text()='Experienced Team']")
    public WebElement experiencedTeamHeader;

    @FindBy(xpath = "//h3[text()='Good Track Records']")
    public WebElement goodTrackRecordsHeader;




}

