import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonProductSearch {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\JDCA\\Downloads\\chromedriver.exe");

//        Open Amazon app
        WebDriver webDriver = new ChromeDriver();
        webDriver.navigate().to("https://www.amazon.in/");

//        Click on Mobile menu from menubar
        webDriver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[2]")).click();

//        Search One plus Nord Mobile and
        WebElement search = webDriver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        search.sendKeys("oneplus nord");
        search.sendKeys(Keys.ENTER);

//        click on one plus Nord 5G (Gray) mobile
        WebElement webElementOnePlusNord5G = webDriver.findElement(By.xpath
                ("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[3]/div/span/div/div/" +
                        "div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span"));

        String stringOnePlusNord5G = webElementOnePlusNord5G.getText();

        if(stringOnePlusNord5G.equals("OnePlus Nord 5G (Gray Onyx, 12GB RAM, 256GB Storage)")) {
            webElementOnePlusNord5G.click();
        }

//      Select option Buy Now
        webDriver.findElement(By.xpath("//*[@id=\"buy-now-button\"]"));

//        Further process require bank details and otp.
    }
}
