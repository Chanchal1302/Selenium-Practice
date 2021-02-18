import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchOnGoogle {
    public static void main (String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JDCA\\Downloads\\chromedriver.exe");

        WebDriver webDriver = new ChromeDriver();
        webDriver.navigate().to("http://www.google.com/");

        webDriver.findElement(By.name("q")).sendKeys(new CharSequence[]{"Velocity Works \n"});

        try {
            webDriver.findElement(By.name("btnK")).click();
        }
        catch (NoSuchElementException var3) {
            Thread.sleep(500L);
        }

        webDriver.findElement(By.name("q")).clear();
        Thread.sleep(200L);

        webDriver.navigate().back();
        Thread.sleep(200L);

        webDriver.navigate().forward();
        Thread.sleep(200L);

        webDriver.navigate().refresh();
        Thread.sleep(200L);

        webDriver.quit();
    }
}