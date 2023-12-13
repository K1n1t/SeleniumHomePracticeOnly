package Selenium.inrtoduction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumBasics {
    WebDriver driver;
    @BeforeMethod
    public void beforeTest1(){
        driver = new ChromeDriver();
        driver.get("https://github.com/CodeFish-CodeFish/Project1Batch18");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test
    public void test1(){

        System.out.println("driver.get.Title() = "+ driver.getTitle());
        System.out.println("============");
        System.out.println("driver.getCurrentUrl() = "+ driver.getCurrentUrl());
        driver.findElement(By.cssSelector("a[title='Batch_18_Projects.iml']"));

    }
}
