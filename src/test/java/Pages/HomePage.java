package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class HomePage {
    WebDriver driver;
    WebElement hamburgerMenuButton, shoppingCartIcon, shoppingCartBadge, productSortButton, removeProductButton, productNameLink;

    public int counter;
    List<WebElement> addToCartButton;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getAddToCartButton() {
        return driver.findElements(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory "));
    }

    public List<WebElement> getRemoveButton() {
        return driver.findElements(By.cssSelector(".btn.btn_secondary.btn_small.btn_inventory "));
    }

    public WebElement getHamburgerMenuButton() {

        return driver.findElement(By.id("react-burger-menu-btn"));
    }


    public WebElement getProductSortButton() {

        return driver.findElement(By.className("product_sort_container"));
    }

    public WebElement getShoppingCartBadge() {

        return driver.findElement(By.className("shopping_cart_badge"));
    }

    public WebElement getShoppingCartIcon() {

        return driver.findElement(By.id("shopping_cart_container"));
    }


    public void clickOnAddToCartRandom() {

        Random r = new Random();
        int randomValue = r.nextInt(getAddToCartButton().size());
        getAddToCartButton().get(randomValue).click();
    }


    public void goToCart() {

        getShoppingCartIcon().click();
    }


    public WebElement getProductNameLink() {
        return driver.findElement(By.className("inventory_item_name"));
    }

    public void clickOnAProductNameLink(String productName) {


        if (getProductNameLink().getText().equalsIgnoreCase(productName)) {

            getProductNameLink().click();
        }

    }

    public void addAProductToCart(String idValue) {

        for (WebElement pivot : getAddToCartButton()) {

            if (pivot.getAttribute("id").equalsIgnoreCase(idValue)) {

                pivot.click();
            }
        }

    }

    public void addAllProducts() {
        for (WebElement element : getAddToCartButton()) {
            if (element.isDisplayed()) {
                element.click();
            }
        }


    }

    public int CountRemoveButtons() {
        int counter = 0;
        for (WebElement element : getRemoveButton()) {
            if (element.isDisplayed()) {
                counter++;
            }

        }
        return counter;
    }


    public void removeASpecificProductFromCart(String idValue) {
        for (WebElement pivot : getRemoveButton()) {
            if (pivot.getAttribute("id").equalsIgnoreCase(idValue)) {
                pivot.click();
            }
        }
    }

    public void userCanSortProductByPrices() {
        List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
        List<Double> pricesList = new ArrayList<>();
        for (WebElement price : priceElements) {

            String priceText = price.getText().replace("$", "").trim();
            pricesList.add(Double.parseDouble(priceText));
        }
    }

    private static boolean isSortedAscending(List<Double> pricesList) {
        List<Double> sortedPrices = new ArrayList<>(pricesList);
        Collections.sort(sortedPrices);
        return pricesList.equals(sortedPrices);
    }







    public int addRandomNumberOfItems() {
        Random random = new Random();
        int numberOfClicks = random.nextInt(getAddToCartButton().size() + 1);

        for (int i = 0; i < numberOfClicks; i++) {

            int randomIndex = random.nextInt(getAddToCartButton().size());
            WebElement randomButton = getAddToCartButton().get(randomIndex);
            randomButton.click();

        }
        return numberOfClicks ;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }


}













