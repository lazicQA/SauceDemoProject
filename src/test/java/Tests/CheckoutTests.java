package Tests;

import Base.BaseTest;
import Base.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    @BeforeMethod
    public void checkoutSetUp() {
        driver.navigate().to("https://www.saucedemo.com/");
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        homePage.clickOnAddToCartRandom();
        homePage.goToCart();
        cartPage.clickOnCheckOutButton();

    }

    @Test
    public void userCanCheckOut(){


        String expectedURL = "https://www.saucedemo.com/checkout-step-one.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test
    public void userCanFillInInformation(){
        String firstName = excelReader.getStringData("CheckoutForm",1,0);
        String lastName = excelReader.getStringData("CheckoutForm", 1,1);
        String zipCode = excelReader.getStringData("CheckoutForm", 1,2);
        checkOutFormPage.inputFirstName(firstName);
        checkOutFormPage.inputLastName(lastName);
        checkOutFormPage.inputZipCode(zipCode);
        Assert.assertEquals(checkOutFormPage.getFirstNameField().getAttribute("value"), firstName);
        Assert.assertEquals(checkOutFormPage.getLastNameField().getAttribute("value"), lastName);
        Assert.assertEquals(checkOutFormPage.getZipCodeField().getAttribute("value"), zipCode);
    }
@Test
public void userCanProceedCheckoutWhenFillInAllFields(){

    String firstName = excelReader.getStringData("CheckoutForm",1,0);
    String lastName = excelReader.getStringData("CheckoutForm", 1,1);
    String zipCode = excelReader.getStringData("CheckoutForm", 1,2);
    checkOutFormPage.inputFirstName(firstName);
    checkOutFormPage.inputLastName(lastName);
    checkOutFormPage.inputZipCode(zipCode);
    checkOutFormPage.clickOnContinueButton();
    String expectedURL = "https://www.saucedemo.com/checkout-step-two.html";
    Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

}
    @Test
    public void totalPriceIsDisplayed() {

        String firstName = excelReader.getStringData("CheckoutForm",1,0);
        String lastName = excelReader.getStringData("CheckoutForm", 1,1);
        String zipCode = excelReader.getStringData("CheckoutForm", 1,2);
        checkOutFormPage.inputFirstName(firstName);
        checkOutFormPage.inputLastName(lastName);
        checkOutFormPage.inputZipCode(zipCode);
        checkOutFormPage.clickOnContinueButton();
        Assert.assertTrue(checkoutOverviewPage.getTotalToPay().isDisplayed());


    }
    @Test
    public void userCannotProceedCheckoutWithoutFillingInAllFields() {

        checkOutFormPage.getFirstNameField().clear();
        checkOutFormPage.getLastNameField().clear();
        checkOutFormPage.getZipCodeField().clear();
        checkOutFormPage.clickOnContinueButton();
        Assert.assertTrue(checkOutFormPage.getErrorMessage().isDisplayed());
        String expectedURL = "https://www.saucedemo.com/checkout-step-one.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

    }


@Test
    public void userCanFinishPurchase(){

    String firstName = excelReader.getStringData("CheckoutForm",1,0);
    String lastName = excelReader.getStringData("CheckoutForm", 1,1);
    String zipCode = excelReader.getStringData("CheckoutForm", 1,2);
    checkOutFormPage.inputFirstName(firstName);
    checkOutFormPage.inputLastName(lastName);
    checkOutFormPage.inputZipCode(zipCode);
    checkOutFormPage.clickOnContinueButton();
    checkoutOverviewPage.clickFinish();
    String expectedURL = "https://www.saucedemo.com/checkout-complete.html";
    Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
}

@Test
public void userCanGoBackToHomePageAfterPurchase(){


    String firstName = excelReader.getStringData("CheckoutForm",1,0);
    String lastName = excelReader.getStringData("CheckoutForm", 1,1);
    String zipCode = excelReader.getStringData("CheckoutForm", 1,2);
    checkOutFormPage.inputFirstName(firstName);
    checkOutFormPage.inputLastName(lastName);
    checkOutFormPage.inputZipCode(zipCode);
    checkOutFormPage.clickOnContinueButton();
    checkoutOverviewPage.clickFinish();
    checkoutCompletePage.clickOnBackHomeButton();
    String expectedURL = "https://www.saucedemo.com/inventory.html";
    Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

}

}


