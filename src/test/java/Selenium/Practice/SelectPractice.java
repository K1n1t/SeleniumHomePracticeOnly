package Selenium.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtil;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

import static utils.BrowserUtil.getAllOptionsSelect;

public class SelectPractice {
    WebDriver driver;
    @BeforeMethod
    public void before(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test
    public void validateSelect(){

        driver.navigate().to("https://www.amazon.com/");
        WebElement dropdown = driver.findElement(By.xpath("//div[@class='nav-search-scope nav-sprite']//div[@class='nav-search-facade']//following-sibling::select[@aria-describedby='searchDropdownDescription']"));
        dropdown.click();
        Select select = new Select(dropdown);
        List<WebElement> allOptions = select.getOptions();
        for (WebElement element : allOptions){
            System.out.println(element.getText());
        }

        WebElement element = select.getFirstSelectedOption();
        Assert.assertEquals(element.getText().trim(), "All Departments");

        driver.quit();
    }

    @Test
    public void usingSelectMethod(){
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement dropdown = driver.findElement(By.cssSelector("select[name='passCount']"));
        Select select1 = new Select(dropdown);
        select1.selectByValue("3");

        WebElement dropdown2 = driver.findElement(By.cssSelector("select[name='fromPort']"));
        BrowserUtil.selectBy(dropdown2,"Zurich", "visibleText");

        WebElement dropMonth = driver.findElement(By.cssSelector("select[name='fromMonth']"));
        BrowserUtil.selectBy(dropMonth,"November","visibleText");

        WebElement day = driver.findElement(By.cssSelector("select[name='fromDay']"));
        BrowserUtil.selectBy(day,"18","index");

        WebElement toPort = driver.findElement(By.cssSelector("select[name='toPort']"));
        Select toPortSelect = new Select(toPort);
        List<WebElement> allPorts = toPortSelect.getOptions();
        for (WebElement port : allPorts) {
            System.out.println(port.getText());
            if (port.getText().equals("Paris")){
                toPortSelect.selectByVisibleText("Paris");
            }
        }
        }

        @Test
    public void option(){
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement allPorts = driver.findElement(By.cssSelector("select[name='fromPort']"));
        Select select = new Select(allPorts);
        List<WebElement> listOfPorts = select.getOptions();
        for (WebElement port : listOfPorts){
            System.out.println(port.getText());
        }
            System.out.println("============================-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        }

        @Test
    public void option2(){
        driver.get("https ://demo.guru99.com/test/newtours/reservation.php");
        WebElement allPorts = driver.findElement(By.cssSelector("select[name='fromPort']"));
        List<WebElement> allPorts2 = getAllOptionsSelect(allPorts);
        for (WebElement port : allPorts2){
            System.out.println(port.getText());
        }
    }
}

