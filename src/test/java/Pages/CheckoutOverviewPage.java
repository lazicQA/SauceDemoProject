package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {
    WebDriver driver;
    WebElement totalToPay, finishButton;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTotalToPay() {
        return driver.findElement(By.cssSelector(".summary_info_label.summary_total_label"));
    }

    public WebElement getFinishButton() {
        return driver.findElement(By.id("finish"));
    }
    public void clickFinish(){
        getFinishButton().click();
    }
}
