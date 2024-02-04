package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CartPage {


    WebDriver driver;
    WebElement quantity, checkoutButton, ProductInCartLink, continueShoppingButton, removeButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getQuantity() {
        return driver.findElement(By.className("cart_quantity"));
    }

    public WebElement getCheckoutButton() {
        return driver.findElement(By.id("checkout"));
    }

    public void clickOnCheckOutButton() {

        getCheckoutButton().click();
    }

    public WebElement getContinueShoppingButton() {
        return driver.findElement(By.id("continue-shopping"));
    }

    public void clickOnContiuneShoppingButton() {
        getContinueShoppingButton().click();
    }

    public WebElement getProductInCartLink() {
        return driver.findElement(By.className("inventory_item_name"));
    }

    public List<WebElement> removeButtons;

    public String numberOfItemsInCart() {

        int counter = 0;

        List<WebElement> quantity = driver.findElements(By.className("cart_quantity"));
        for (int i = 0; i < quantity.size(); i++) {
            if (quantity.get(i).getText().equals("1")) {
                counter++;
            }
        }
        return Integer.toString(counter);
    }
    public List<WebElement> getRemoveButtons() {
        return driver.findElements(By.cssSelector(".btn.btn_secondary.btn_small.cart_button"));
    }

    public Integer countItemsInCart() {

        int counter = 0;

        List<WebElement> quantity = driver.findElements(By.className("cart_quantity"));
        for (int i = 0; i < quantity.size(); i++) {
            if (quantity.get(i).getText().equals("1")) {
                counter++;
            }
        }
        return counter;
    }

    public WebElement getRemoveButton() {
        return driver.findElement(By.cssSelector(".btn.btn_secondary.btn_small.cart_button"));
    }

    public void removeAllProductsFromCart() {
        for (WebElement element:getRemoveButtons())
        while (element.isDisplayed()) {
            element.click();
            break;
        }

    }

    public void verifyThatCartIsEmpty() {
        try {
            Assert.assertFalse(getProductInCartLink().isDisplayed());
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Assert.assertFalse(getQuantity().isDisplayed());
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}