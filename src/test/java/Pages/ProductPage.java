package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    WebDriver driver;
    WebElement ProductTitle, addToCartButton, cartIcon;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getProductTitle() {
        return driver.findElement(By.cssSelector(".inventory_details_name.large_size"));
    }

    public WebElement getAddToCartButton() {
        return driver.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
    }
    public void clickOnAddToCartButton(){
        getAddToCartButton().click();
    }


    public WebElement getCartIcon() {
        return driver.findElement(By.id("shopping_cart_container"));
    }
    public void goToCart() {

        getCartIcon().click();

    }
}

