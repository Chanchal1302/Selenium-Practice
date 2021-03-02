import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwagLabs {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\JDCA\\Downloads\\chromedriver.exe");

        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to("https://www.saucedemo.com/");

        sleep(2000);

//        login to the Swag labs
        webDriver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
        webDriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        sleep(2000);
        webDriver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        sleep(1000);

//        to see the product details
        webDriver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).click();
        webDriver.navigate().back();
        sleep(2000);

//        add multiple products into cart
        webDriver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button")).click();
        sleep(500);
        webDriver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[3]/div[3]/button")).click();
        sleep(500);
        webDriver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[4]/div[3]/button")).click();
        sleep(1000);

//        click on cart icon
        webDriver.findElement(By.id("shopping_cart_container")).click();
        sleep(1000);

//        on the cart page remove one item
        /*webDriver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/button")).click();
        sleep(1000);*/

//        scroll down and then up
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("window.scrollBy(0,600)");
        javascriptExecutor.executeScript("window.scrollBy(0,-600)");

        sleep(1000);

//        click on checkout
        webDriver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]")).click();
        sleep(1000);

//        Fill customer information and click on continue
        webDriver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Tony");
        webDriver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Stark");
        webDriver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("546011");
        sleep(1000);
        webDriver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[2]/input")).click();
        sleep(1000);

//        scroll down
        javascriptExecutor.executeScript("window.scrollBy(0,1000)");
        sleep(1000);

//        click on Finish
        webDriver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]")).click();
        sleep(1000);

//        Final Page
        String success = webDriver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText();

        if(success.contains("THANK YOU")) {
            System.out.println("Order Placed Successfully");
        }

        else {
            System.out.println("Order has not been placed");
        }
        sleep(1000);

        webDriver.close();
    }

    private static void sleep(int time) throws InterruptedException {
        Thread.sleep(time);
    }
}
