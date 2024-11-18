package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CityChoosePage extends BasePage {

    public CityChoosePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(@id, 'menu-button')][preceding-sibling::a[contains(@href, 'offices')]]")
    private WebElement listCitiesButton;
    @FindBy(xpath = "//button[text()='Краснодар']")
    private WebElement cityKrasnodarButton;

    public void chooseCity(String city) {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(listCitiesButton));
        button.click();
        WebElement cityOption = wait.until(ExpectedConditions.elementToBeClickable(cityKrasnodarButton));
        cityOption.click();
        wait.until(ExpectedConditions.textToBePresentInElement(listCitiesButton, city));
    }

    public String getSelectedCity() {
        return listCitiesButton.getText();
    }

}
