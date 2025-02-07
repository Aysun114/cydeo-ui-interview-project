package cydeoInterview.tests;

import cydeoInterview.utilities.ConfigurationReader;
import cydeoInterview.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class InputTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void input_test(){
        //     1- Go to the url = https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html
        Driver.getDriver().get(ConfigurationReader.getProperty("calendar.test.url"));

        //     2- Click on Date input area
        WebElement dateInput = Driver.getDriver().findElement(By.id("datepicker"));
        dateInput.click();

        //     3- Get all elements(td) of calendar table using findElements method
        List<WebElement> daysData = Driver.getDriver().findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

        //     4- Get the text of all elements(td) of calendar table
        //     5- Click 7. day of month
        for (WebElement eachDay : daysData) {
            System.out.println("eachDay.getText() = " + eachDay.getText());
            if(eachDay.getText().equals("7")){
                eachDay.click();
            }
        }

        //     6- Verify date of "02/07/2025" has been entered in input area.
        Assert.assertEquals(dateInput.getAttribute("value"),"02/07/2025");

    }
}
