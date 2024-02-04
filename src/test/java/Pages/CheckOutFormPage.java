package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutFormPage {
    WebDriver driver;
    WebElement firstNameField, lastNameField, zipCodeField, continueButton, errorMessage;

    public CheckOutFormPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getFirstNameField() {
        return driver.findElement(By.id("first-name"));
    }

    public WebElement getLastNameField() {
        return driver.findElement(By.id("last-name"));
    }

    public WebElement getZipCodeField() {
        return driver.findElement(By.id("postal-code"));
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.id("continue"));
    }

    public void inputFirstName(String firstName) {

        getFirstNameField().clear();
        getFirstNameField().sendKeys(firstName);
    }

    public void inputLastName(String lastName) {

        getLastNameField().clear();
        getLastNameField().sendKeys(lastName);
    }

    public void inputZipCode(String zipCode) {

        getZipCodeField().clear();
        getZipCodeField().sendKeys(zipCode);
    }
public void clickOnContinueButton () {

        getContinueButton().click();
}

    public WebElement getErrorMessage() {
        return driver.findElement(By.cssSelector(".error-message-container.error"));
    }
}