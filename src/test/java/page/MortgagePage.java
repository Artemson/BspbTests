package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class MortgagePage extends BasePage {

    public MortgagePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[text()='Ипотека']")
    private WebElement tabMortgage;
    @FindBy(xpath = "//div[@role='tabpanel' and not (@hidden)]//*[preceding-sibling::p[text()='Ежемесячный платеж']]")
    private WebElement monthlyPayment;
    @FindBy(xpath = "//div[@role='tabpanel' and not (@hidden)]//h2[preceding-sibling::p[text()='Ставка']]")
    private WebElement rate;
    @FindBy(xpath = "//input[preceding-sibling::p[text()='Стоимость недвижимости']]")
    private WebElement priceOfRealty;
    @FindBy(xpath = "//input[preceding-sibling::p[text()='Срок']]")
    private WebElement timeMortgage;
    @FindBy(xpath = "//input[preceding-sibling::p[text()='Первоначальный взнос']]")
    private WebElement initialPayment;


    public void inputMortgageData(String price, String time, String initial) {
        actions.moveToElement(tabMortgage).click().perform();


        waitElementBeClicable(priceOfRealty);
        oldValue = monthlyPayment.getText();
        sendData(priceOfRealty, price);
        waitForTextChange(monthlyPayment, oldValue);

        waitElementBeClicable(timeMortgage);
        oldValue = monthlyPayment.getText();
        sendData(timeMortgage, time);
        waitForTextChange(monthlyPayment, oldValue);

        waitElementBeClicable(initialPayment);
        oldValue = monthlyPayment.getText();
        sendData(initialPayment, initial);
        waitForTextChange(monthlyPayment, oldValue);
    }

    public Map<String, String> getActualResult() {
        return Map.of("monthlyPayment", monthlyPayment.getText(), "rate", rate.getText());
    }
}
