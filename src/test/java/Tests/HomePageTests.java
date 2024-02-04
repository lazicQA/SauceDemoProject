package Tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    @BeforeMethod
    public void HomePageSetup() {
        driver.navigate().to("https://www.saucedemo.com/");
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
    }

    @Test
    public void UserCanAddASpecificProductInCart() {


        homePage.goToCart();
        cartPage.verifyThatCartIsEmpty();
        cartPage.clickOnContiuneShoppingButton();
        String idValue = excelReader.getStringData("ProductsInfo", 1, 1);
        homePage.addAProductToCart(idValue);
        homePage.goToCart();
        Assert.assertTrue(cartPage.getProductInCartLink().isDisplayed());


    }

    @Test
    public void UserCanRemoveAddedProductFromHomePage() {
        String idValueADD = excelReader.getStringData("ProductsInfo", 1, 1);
        String idValueREMOVE = excelReader.getStringData("ProductsInfo", 1, 2);
        homePage.addAProductToCart(idValueADD);
        homePage.goToCart();
        Assert.assertTrue(cartPage.getProductInCartLink().isDisplayed());
        cartPage.clickOnContiuneShoppingButton();
        homePage.removeASpecificProductFromCart(idValueREMOVE);
        homePage.goToCart();
        try {
            Assert.assertFalse(driver.findElement(By.id(idValueREMOVE)).isDisplayed());
        } catch (Exception e) {
            System.out.println(e);
        }
       //cartPage.verifyThatCartIsEmpty();


    }

    @Test
    public void UserCanAddARandomProductInCart() {

        homePage.clickOnAddToCartRandom();
        homePage.getShoppingCartIcon().click();
        Assert.assertTrue(cartPage.getQuantity().isDisplayed());
        Assert.assertTrue(cartPage.getProductInCartLink().isDisplayed());
    }

    @Test
    public void userCanAddARandomNumberOfProductsInCart() {
        homePage.goToCart();
        cartPage.verifyThatCartIsEmpty();
        cartPage.clickOnContiuneShoppingButton();
        int clickCount = homePage.addRandomNumberOfItems();
        homePage.goToCart();
        int itemCount = cartPage.countItemsInCart();


    Assert.assertEquals (clickCount, itemCount);


            }


    @Test
    public void UserCanRemoveProductsFromCart() {
        int clickCount = homePage.addRandomNumberOfItems();
        homePage.goToCart();
        int itemCount = cartPage.countItemsInCart();
        Assert.assertEquals (clickCount, itemCount);
        cartPage.removeAllProductsFromCart();
        cartPage.verifyThatCartIsEmpty();


    }

    @Test
    public void UserCanAddProductToCartFromProductsPage() {
        String product1 = excelReader.getStringData("ProductsInfo", 1, 0);
        homePage.clickOnAProductNameLink(product1);
        productPage.clickOnAddToCartButton();
        productPage.goToCart();
        Assert.assertTrue(cartPage.getProductInCartLink().isDisplayed());
        Assert.assertEquals(cartPage.getProductInCartLink().getText(), product1);


    }

    @Test
    public void cartBadgeReflectsCorrectNumberOfItemsInTheCart() {
        String product1 = excelReader.getStringData("ProductsInfo", 1, 1);
        String product2 = excelReader.getStringData("ProductsInfo", 2, 1);
        String product3 = excelReader.getStringData("ProductsInfo", 3, 1);
        homePage.addAProductToCart(product1);
        homePage.addAProductToCart(product2);
        homePage.addAProductToCart(product3);
        homePage.goToCart();

        Assert.assertEquals(cartPage.numberOfItemsInCart(), homePage.getShoppingCartBadge().getText());


    }

    @Test
    public void userCanAddAllProductsInCart(){
        homePage.addAllProducts();
        int numberOfAddedItems = homePage.CountRemoveButtons();
        homePage.goToCart();
        int numberOfItemsInCart = cartPage.countItemsInCart();
        Assert.assertEquals(numberOfAddedItems, numberOfItemsInCart);

    }
    @AfterMethod
    public void closeBrowser(){
       // driver.quit();
    }




}
















