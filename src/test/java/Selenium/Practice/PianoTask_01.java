package Selenium.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PianoTask_01 {

    WebDriver driver;
    @BeforeMethod
    public void before(){
        driver = new ChromeDriver();
        driver.get("https://www.musicca.com/piano");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        System.out.println("before method has been implemented");
    }
    @Test
    public void piano(){
        List<WebElement> allKeys = driver.findElements(By.cssSelector("div[id='piano']"));
        List<String> notes = Arrays.asList("2c", "2e", "2g", "3c", "3d", "3b", "3c", "2g");
        Map<String, WebElement> keyBoard = new LinkedHashMap<>();
        for (WebElement key : allKeys){
            keyBoard.put(key.getAttribute("data-note"), key);
        }
        for (int i = 0; i < keyBoard.size(); i++) {
            //System.out.println(toString(keyBoard.get(i));
        }

    }
}
