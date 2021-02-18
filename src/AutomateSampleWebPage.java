import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomateSampleWebPage {

    public static void main (String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JDCA\\Downloads\\chromedriver.exe");

        WebDriver webDriver = new ChromeDriver();

        webDriver.navigate().to("https://www.testandquiz.com/selenium/testing.html");

        String firstString = webDriver.findElement(By.className("col-md-12")).getText();
        System.out.println("First String --> " + firstString + "\n");

        String secondString = webDriver.findElement(By.xpath("(//div[@class='col-md-12'])[2]")).getText();
        System.out.println("Second String --> " + secondString + "\n");

        webDriver.findElement(By.linkText("This is a link")).click();

        webDriver.navigate().back();

        webDriver.findElement(By.id("fname")).sendKeys(new CharSequence[]{"Testing Selenium Dummy Form"});

        webDriver.findElement(By.id("idOfButton")).click();
        sleepFor(5000);

        webDriver.findElement(By.id("male")).click();
        sleepFor(5000);

        webDriver.findElement(By.cssSelector("input.Automation")).click();
        sleepFor(5000);

        Select selectDropDown = new Select(webDriver.findElement(By.id("testingDropdown")));
        selectDropDown.selectByVisibleText("Manual Testing");
        sleepFor(5000);

        webDriver.close();
    }

    static void sleepFor(int time) throws InterruptedException {
        Thread.sleep((long)time);
    }
}
