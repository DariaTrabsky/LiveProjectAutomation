package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class ServicesPage {
    public ServicesPage(){
        PageFactory.initElements(BrowserUtils.getDriver(),this);
    }

    @FindBy(xpath = "//h4[text()='Finance']")
    public WebElement financeDivisionBtn;

    @FindBy(xpath = "//h4[text()='Information Technology']")
    public WebElement iTDivisionBtn;

    @FindBy(xpath = "//h4[text()='Healthcare']")
    public WebElement healthcareDivisionBtn;

    @FindBy(xpath = "//h4[text()='Government Projects']")
    public WebElement governmentProjectsDivisionBtn;

    @FindBy(xpath = "//div[@class='info-box-three']")
    public WebElement addressDivisionContact;

    @FindBy(xpath = "//div[@class='info-box-three'][2]")
    public WebElement callUsDivisionContact;

    @FindBy(xpath = "//h4[text()='Finance']")
    public WebElement financeInitialLink;

    @FindBy(xpath = "//i[@class='fa fa-file-pdf-o']")
    public WebElement financeNaviBtn;

    @FindBy(xpath = "//i[@class='fa fa-file-word-o']")
    public WebElement iTNaviBtn;

    @FindBy(xpath = "(//i[@class='fa fa-file-pdf-o'])[2]")
    public WebElement healthCareBtn;

    @FindBy(xpath = "(//i[@class='fa fa-file-pdf-o'])[3]")
    public WebElement governmentProjectsBtn;

    @FindBy(xpath = "(//i[@class='fa fa-file-pdf-o'])[4]")
    public WebElement othersBtn;

    @FindBy(xpath = "//h1")
    public WebElement financeHeader;

    @FindBy(xpath = "//h4[text()='Others']")
    public WebElement othersDivisionBtn;


    @FindBy(xpath = "//div[@class='image']")
    public WebElement allDivisionImages;

    @FindBy(xpath = "(//p)[6]")
    public WebElement descriptionBtn;

    @FindBy(xpath = "(//div[@class='text'])[3]")
    public WebElement quote;



}
