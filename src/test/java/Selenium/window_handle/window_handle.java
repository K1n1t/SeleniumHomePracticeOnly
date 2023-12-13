package Selenium.window_handle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtil;

import java.time.Duration;
import java.util.Set;

public class window_handle {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
    }
    @Test(priority = 1)
    public void WindowHandlePractice() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[contains(.,'Click Here')]")).click();
        Thread.sleep(1000);

        String currentPageID = driver.getWindowHandle(); System.out.println(currentPageID);
        BrowserUtil.switchDriverByID(driver,currentPageID);

        WebElement newWindowText = driver.findElement(By.xpath("//div[@class='example']"));
        System.out.println(newWindowText);
    }
    @Test(priority = 2 )
    public void verifyMultipleWindows() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement twitter = driver.findElement(By.xpath("//a[contains(.,'Follow On Twitter')]"));
        //BrowserUtil.clickOnElement(twitter);
        twitter.click();
        Thread.sleep(900);

        WebElement facebook = driver.findElement(By.xpath("//a[contains(.,'Like us On Facebook')]"));
        //BrowserUtil.clickOnElement(facebook);
        facebook.click();
        Thread.sleep(900);

        WebElement linkedin = driver.findElement(By.xpath("//a[contains(.,'Follow us On Linkedin')]"));
        // BrowserUtil.clickOnElement(linkedin);
        linkedin.click();


        Set<String> windowHandles = driver.getWindowHandles();
        String wantedTitle = "LambdaTest | San Francisco CA | Facebook";
        Thread.sleep(800);
        for (String id : windowHandles) {
            driver.switchTo().window(id);
            Thread.sleep(400);
            if (BrowserUtil.getTitleWithJS(driver).contains(wantedTitle)) {
//                driver.switchTo().window(id);
//                System.out.println("fakebuk");
                break;

            }
        }
        System.out.println(BrowserUtil.getTitleWithJS(driver));
        driver.close();

    }







    @AfterMethod
        public void afterAll () throws InterruptedException {
            Thread.sleep(500);
            driver.quit();
        }
    }
