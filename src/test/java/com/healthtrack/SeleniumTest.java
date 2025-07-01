package com.healthtrack;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {

    @Test
    public void testFormInteraction() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        driver.get("http://localhost:8080/index.html");

        driver.findElement(By.id("nombre")).sendKeys("Luis");
        driver.findElement(By.id("peso")).sendKeys("75");
        driver.findElement(By.tagName("button")).click();

        WebElement result = driver.findElement(By.id("resultado"));
        assertTrue(result.getText().contains("Peso Actual"), "Response contains weight update");

        driver.quit();
    }
}
