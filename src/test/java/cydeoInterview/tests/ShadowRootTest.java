package cydeoInterview.tests;

import cydeoInterview.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ShadowRootTest {

    @Test
    public void hidden_element_shadow_root_test(){

        Driver.getDriver().get("https://practice.expandtesting.com/shadowdom");

        WebElement shadowHost = Driver.getDriver().findElement(By.id("shadow-host"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        shadowRoot.findElement(By.cssSelector("#my-btn")).click();

    }
}
