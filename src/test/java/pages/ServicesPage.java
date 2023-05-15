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


}
