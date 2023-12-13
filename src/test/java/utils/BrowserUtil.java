package utils;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class BrowserUtil {

    public static void selectBy(WebElement element, String value, String methodName) {

        Select select = new Select(element);
        switch (methodName){
            case "visibleText":
                select.selectByVisibleText(value);
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;

            default:
                System.out.println("Method name is not available, please use visibleText or index");
        }
    }

    public static List<WebElement> getAllOptionsSelect(WebElement element){
        Select select = new Select(element);
        List<WebElement>  options = select.getOptions();
        return options;
    }

    public static void clickOnElement(WebElement element){
        element.click();
    }






                                        // JavaScript
    public static String getTitleWithJS(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString();
    }

    public static void clickWithJS(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click",element);
    }

    public static void scrollWithJS(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }





    public static void switchDriverByID(WebDriver driver, String currentPageID) {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String id : windowHandles){
            if (!id.equals(currentPageID)){
                driver.switchTo().window(id);
            }
        }
    }

    public static void switchWindowsByTitle(WebDriver driver, String title){
        Set<String> windowHandles = driver.getWindowHandles();
        for (String id : windowHandles){
            driver.switchTo().window(id);

            if (driver.getTitle().contains(title)){
                break;
            }
        }
    }

        // alert
    public static void acceptAlert(WebDriver driver, WebElement element){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public static String getTextAlert(WebDriver driver){
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public static void dismissAlert(WebDriver driver){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public static void sendKeysAlert(WebDriver driver, String keys ){
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(keys);
    }
}
