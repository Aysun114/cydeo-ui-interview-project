package cydeoInterview.tests;

import cydeoInterview.utilities.ConfigurationReader;
import cydeoInterview.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToolTipTest {

    @Test
    public void tool_tip_test(){

        //     1. Go to https://practice.expandtesting.com/tooltips
        Driver.getDriver().get(ConfigurationReader.getProperty("toolTip.test.url"));

        //     2. Verify tooltip for the element "Tooltip on bottom" is displayed correctly.
        WebElement toolTip = Driver.getDriver().findElement(By.id("btn3"));

        Assert.assertEquals(toolTip.getAttribute("title"),"Tooltip on bottom");

        Driver.closeDriver();
    }
}
