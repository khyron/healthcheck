package com.healthtrack;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {

    @Test
    public void testFormInteraction() throws Exception {
        String baseUrl = System.getenv("BASE_URL");
        if (baseUrl == null || baseUrl.isEmpty()) {
            baseUrl = "http://localhost:8080";
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get(baseUrl + "/index.html");

            driver.findElement(By.id("nombre")).sendKeys("Luis");
            driver.findElement(By.id("peso")).sendKeys("75");
            driver.findElement(By.tagName("button")).click();

            WebElement result = driver.findElement(By.id("resultado"));
            assertTrue(result.getText().contains("Peso Actual"));
        } finally {
            driver.quit();
        }
    }
}
