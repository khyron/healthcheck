package com.healthtrack;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.io.File;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class SeleniumTest {

    @Test
    public void testFormInteraction() throws Exception {
        String baseUrl = System.getenv("BASE_URL");
        if (baseUrl == null || baseUrl.isEmpty()) {
            baseUrl = "http://localhost:8080";
        }

        Path tempProfileDir = Files.createTempDirectory("chrome-profile-");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        options.addArguments("--user-data-dir=" + tempProfileDir.toAbsolutePath().toString());

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

            // Limpia el directorio temporal
            Files.walk(tempProfileDir)
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
        }
    }
}