import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SmartBearWebAppTesting {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\JDCA\\Downloads\\chromedriver.exe");

        WebDriver webDriver = new ChromeDriver();

//        opening smart bear software app
        webDriver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders" +
                "/Login.aspx?ReturnUrl=%2fsamples%2ftestcomplete11%2fweborders%2f");
        sleep(2000);

//        send username and password to fields
        webDriver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_username\"]")).sendKeys("Tester");
        webDriver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_password\"]")).sendKeys("test");

//        click on login button
        webDriver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_login_button\"]")).click();
        sleep(2000);

//        fetch card number for all the users
        List<WebElement> allCard = webDriver.findElements(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr/td[11]"));

        int i = 0;
        for(WebElement singleCard : allCard) {
            System.out.println("Card [" +i+ "] : " +singleCard.getText());
            i++;
        }

//        delete one entry let's say name = "Bob Feather
        webDriver.findElement(By.id("ctl00_MainContent_orderGrid_ctl07_OrderSelector")).click();
        sleep(2000);

        webDriver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_btnDelete\"]")).click();

//        click on order form will be open then fill it
        webDriver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a")).click();


//        fill all the values
//        change value from drop down
        Select selectDropDown = new Select(webDriver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_ddlProduct\"]")));
        selectDropDown.selectByValue("FamilyAlbum");

        webDriver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtQuantity\"]")).sendKeys("125");
        webDriver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtUnitPrice\"]"))
                .sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.DELETE);
        webDriver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtUnitPrice\"]")).sendKeys("90");
        webDriver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtDiscount\"]")).sendKeys("10");

        webDriver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtName\"]")).sendKeys("Tony Stark");
        webDriver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox2\"]")).sendKeys("Stark Tower");
        webDriver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox3\"]")).sendKeys("New York");
        webDriver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox4\"]")).sendKeys("NYC State");
        webDriver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox5\"]")).sendKeys("10001");
        webDriver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_cardList_1\"]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox6\"]"))
                .sendKeys("987654321098");
        webDriver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox1\"]")).sendKeys("02/22");
        sleep(1000);

//        click on Process button
        webDriver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_InsertButton\"]")).click();

        System.out.println("Message : "
                +webDriver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong")).getText());
        sleep(1000);

        webDriver.close();
    }

    private static void sleep(int time) throws InterruptedException {
        Thread.sleep(time);
    }
}
