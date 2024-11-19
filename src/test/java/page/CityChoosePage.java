package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CityChoosePage extends BasePage {

    public CityChoosePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(@id, 'menu-button')][preceding-sibling::a[contains(@href, 'offices')]]")
    private WebElement listCitiesButton;

    public void chooseCity(String city) {
        clickElement(listCitiesButton);
        clickElement(driver.findElement(By.xpath("//button[text()='" + city + "']")));
        waitTextInElement(listCitiesButton, city);
    }

    public String getSelectedCity() {
        return listCitiesButton.getText();
    }

}
