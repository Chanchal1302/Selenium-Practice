import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Collections;
import java.util.List;

public class PaytmFlightBooking {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\JDCA\\Downloads\\chromedriver.exe");

        WebDriver webDriver = new ChromeDriver();
        webDriver.navigate().to("https://paytm.com/");

//        click on flight icon to book
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[1]/div/a[4]/div")).click();

//        enter city in from text field
        WebElement from = webDriver.findElement(By.xpath("(//*[@id=\"text-box\"])[1]"));
        enterData(from, "stv", 2000);

//        enter city in to text field
        WebElement to = webDriver.findElement(By.xpath("(//*[@id=\"text-box\"])[2]"));
        enterData(to, "blr", 2000);

//        click on Departure date box
        webDriver.findElement(By.xpath("//*[@id=\"datePickerOnward\"]/div[1]/div")).click();
        Thread.sleep(2000);

        String selectMonth = "September '21";
//            get month from the date picker
        while (true)
        {
            String fMonth = webDriver.findElement(By.xpath("//*[@id=\"datePickerOnward\"]/div[2]/div/div/p")).getText();

            if (fMonth.equals(selectMonth)) {
                break;
            }

            else {
                webDriver.findElement(By.xpath("//*[@id=\"moveToNext\"]")).click();
                Thread.sleep(2000);
            }
        }

        String selectDate = "25";
//        select date from the calender
        List<WebElement> allDates = webDriver.
                findElements((By.xpath("//*[@id=\"datePickerOnward\"]/div[2]/div/div[3]/table/tbody/tr/td/div/div/div[1]")));

        for (WebElement date : allDates) {
            if (date.getText().equals(selectDate)) {
                date.click();
                break;
            }
        }

        Thread.sleep(3000);

//        click on search
        WebElement search = webDriver.findElement(By.xpath("//*[@id=\"flightsBookingForm\"]/div[2]/div[8]/div/button"));
        search.click();


    }

    private static void enterData(WebElement webElement, String city, int time) throws InterruptedException {
        webElement.sendKeys(city);
        Thread.sleep(time);
        webElement.sendKeys(Keys.ARROW_DOWN);
        webElement.sendKeys(Keys.ENTER);
        Thread.sleep(time);
    }
}
