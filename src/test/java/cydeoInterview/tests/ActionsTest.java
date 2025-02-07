package cydeoInterview.tests;

import cydeoInterview.utilities.BrowserUtils;
import cydeoInterview.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsTest {

    @Test
    public void actions_test(){
        //     1. Go to  "https://www.globalsqa.com/demo-site/draganddrop/"
        Driver.getDriver().get("https://www.globalsqa.com/demo-site/draganddrop/");

        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.cssSelector(".demo-frame.lazyloaded")));

        //     2. Locate "High Tatras" and "High Tatras 2" as sources and  "Trash" as target elements
        WebElement highTatras = Driver.getDriver().findElement(By.xpath("//h5[.='High Tatras']"));
        WebElement highTatras2= Driver.getDriver().findElement(By.xpath("//h5[.='High Tatras 2']"));
        WebElement trash = Driver.getDriver().findElement(By.id("trash"));

        //     3. Drag and Drop "High Tatras" and "High Tatras 2" into "Trash"
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(highTatras,trash).perform();
        actions.dragAndDrop(highTatras2,trash).perform();

        BrowserUtils.sleep(3);

       // BrowserUtils.waitForVisibility(highTatras2,10);

        //     4. Verify 2 images moved to the trash
        List<WebElement> trashItems = Driver.getDriver().findElements(By.xpath("//div[@id='trash']//li"));

        Assert.assertTrue(trashItems.size()==2);

        Driver.closeDriver();

    }
}
