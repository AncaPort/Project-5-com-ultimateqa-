package testsuite;
/**
 * 2. Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * 3. Write down the following test into ‘LoginTest’ class
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    /**
     * 1. userShouldNavigateToLoginPageSuccessfully *
     * click on the ‘Sign In’ link
     * * Verify the text ‘Welcome Back!
     */
    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        //Verify the text ‘Welcome Back!'
        String expectedResult = "Welcome Back!";
        String actualResult = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        Assert.assertEquals("user not able to click on sign in", expectedResult, actualResult);
    }

    /**
     * 2. verifyTheErrorMessage
     * * click on the ‘Sign In’ link
     * * Enter invalid username
     * * Enter invalid password
     * * Click on Login button
     * * Verify the error message ‘Invalid email
     * or password.’
     */
    @Test
    public void verifyTheErrorMessage() {
        //click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        //Enter invalid username
        driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys("ketty@gmail.com");
        //Enter invalid password
        driver.findElement(By.xpath("//input[@id='user[password]']")).sendKeys("ket123");
        //Click on Login button
        driver.findElement(By.xpath("//button[@data-sitekey='6LdhwsclAAAAAHilv5EFCsSoCU6bTSlfgfuMFlBm']")).click();
        //Verify the error message ‘Invalid email or password.’
        String expected = "Invalid email or password.";
        String actual = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals("user not login successfully", expected, actual);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
