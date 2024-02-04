package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    String validUsername = "standard_user";
    String validPassword = "secret_sauce";
    String invalidPassword = "wrongpass";

    @BeforeMethod
    public void pageSetup() {

        driver.navigate().to("https://www.saucedemo.com/");

    }

    @Test
    public void verifyThatUserCanLoginWithValidCredentials() {

        String expectedURL = "https://www.saucedemo.com/inventory.html";
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }
    @Test
    public void verifyThatUserCannotLoginWithoutFillingInUsernameAndPassword(){

        loginPage.getUsernameField().clear();
        loginPage.getPasswordField().clear();
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        String expectedURL = "https://www.saucedemo.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

    }
    @Test
    public void verifyThatUserCannotLoginWithWrongPassword(){
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(invalidPassword);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        String expectedURL = "https://www.saucedemo.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertNotEquals( driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

}
