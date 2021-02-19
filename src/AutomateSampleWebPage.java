import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AutomateSampleWebPage {

    public static void main (String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JDCA\\Downloads\\chromedriver.exe");

        WebDriver webDriver = new ChromeDriver();

//        load the website.
        webDriver.navigate().to("https://www.testandquiz.com/selenium/testing.html");

//        to get first string
        String firstString = webDriver.findElement(By.className("col-md-12")).getText();
        System.out.println("First String --> " + firstString + "\n");

//        to get second string
        String secondString = webDriver.findElement(By.xpath("(//div[@class='col-md-12'])[2]")).getText();
        System.out.println("Second String --> " + secondString + "\n");

//        perform  click on link
        webDriver.findElement(By.linkText("This is a link")).click();

//        go  to back page
        webDriver.navigate().back();

//        to enter data into text field
        webDriver.findElement(By.id("fname")).sendKeys(new CharSequence[]{"Testing Selenium Dummy Form"});

//        to click on button
        webDriver.findElement(By.id("idOfButton")).click();
        sleepFor(5000);

//        select radio button
        webDriver.findElement(By.id("male")).click();
        sleepFor(5000);

//        select the checkbox
        webDriver.findElement(By.cssSelector("input.Automation")).click();
        sleepFor(5000);

//        select from drop down.
        Select selectDropDown = new Select(webDriver.findElement(By.id("testingDropdown")));
//        selectDropDown.selectByVisibleText("Manual Testing");
//        selectDropDown.selectByIndex(1);
        selectDropDown.selectByValue("Database");
        sleepFor(5000);

//        Double click the button
        Actions action = new Actions(webDriver);
        WebElement link =webDriver.findElement(By.id("dblClkBtn"));
        action.doubleClick(link).perform();

//        Switch to the alert box and click on OK button
        Alert alert = webDriver.switchTo().alert();
        System.out.println("Alert Text --> " +alert.getText());
        sleepFor(2500);

        alert.accept();
        sleepFor(2500);

//        Drag one element and drop it on another element
//        WebElement source = webDriver.findElement(By.xpath("//*[@id=\"sourceImage\"]"));
//        WebElement target = webDriver.findElement(By.xpath("//*[@id=\"targetDiv\"]"));

//        Actions dragAndDropAction = new Actions(webDriver);
//        dragAndDropAction.dragAndDrop(source,target).build().perform();
//        dragAndDropAction.clickAndHold(source).pause(2000).moveToElement(target).release(target).build().perform();

        /*Actions builder = new Actions(webDriver);
        builder.keyDown(Keys.CONTROL)
                .click(source)
                .dragAndDrop(source, target)
                .keyUp(Keys.CONTROL);

        Action selected = builder.build();

        selected.perform();*/

//        sleepFor(2500);

//        close the browser
        webDriver.close();
    }

    static void sleepFor(int time) throws InterruptedException {
        Thread.sleep((long)time);
    }
}