package Selenium.js_methods;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtil;
import utils.DriverHelper;

import java.time.Duration;
import java.util.Set;

public class JavaScriptMethods {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){

        driver = DriverHelper.getDriver();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //get title method
    @Test
    public void getTitleWithJS(){

        driver.get("https://www.amazon.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title = js.executeScript("return document.title").toString();
        System.out.println("Get title with JS : "+title);
    }

    @Test
    public void cklickWithJS(){
        driver.get("https://codefish.io/");
        WebElement aboutUs = driver.findElement(By.xpath("//button[contains(.,'About us')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", aboutUs);
    }

    @Test
    public void scrollIntoView(){
        driver.get("https://codefish.io/");
        WebElement facebook = driver.findElement(By.cssSelector("a[href='https://www.facebook.com/codefish.camp']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", facebook);
    }

    @Test
    public void practiceJSMethods() throws InterruptedException{

        driver.get("https://www.yale.edu/");
        WebElement contactUS = driver.findElement(By.xpath("//a[contains(.,'Contact Us')]"));
        BrowserUtil.clickWithJS(driver,contactUS);    // Reusable Method
        Thread.sleep(1000);
        BrowserUtil.clickWithJS(driver,contactUS);    // Reusable Method
        String contactUsTitle = BrowserUtil.getTitleWithJS(driver);  // Reusable Method
        Assert.assertEquals(contactUsTitle,"Yale University");
        System.out.println("We got the title with JS -> "+contactUsTitle);

        WebElement webEditor = driver.findElement(By.xpath("//a[.='Contact Web Editor']"));
        BrowserUtil.scrollWithJS(driver,webEditor);   // Reusable Method
        BrowserUtil.clickWithJS(driver,webEditor);    // Reusable Method
        String actualTitleOfWebEditor = BrowserUtil.getTitleWithJS(driver);
        String expectedWebEditorTitle = "Yale University";
        Assert.assertEquals(actualTitleOfWebEditor, expectedWebEditorTitle);
        System.out.println("got title with JS "+actualTitleOfWebEditor);
        String expectedWebEditorTitle1 = "ntact Web Editor | Yale University";
        Assert.assertFalse(actualTitleOfWebEditor.contains(expectedWebEditorTitle1), "Something Went Wrong");
    }

    @Test
    public void multipleTabs() throws InterruptedException {

        // We are just opening multiple window right away
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.amazon.com/')");
        Thread.sleep(1000);
        js.executeScript("window.open('https://www.ebay.com/')");
        Thread.sleep(1000);
        js.executeScript("window.open('https://world.taobao.com/')");
        Thread.sleep(1000);

        String expectedTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";

        System.out.println("=========");
        BrowserUtil.switchWindowsByTitle(driver,expectedTitle);
        System.out.println(BrowserUtil.getTitleWithJS(driver) + "-- Bingo, i got the title for ebay");

    }


























    @AfterMethod
    public void tearDown() throws InterruptedException {
    Thread.sleep(2000);
    //driver.quit();
    }
}
