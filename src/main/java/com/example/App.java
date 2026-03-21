package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class App {

    public static void main(String[] args) throws Exception {

        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("/snap/firefox/current/usr/lib/firefox/firefox");

        WebDriver driver = null;

        try {
            driver = new FirefoxDriver(options);

            // ==============================
            // TAB 1: SauceDemo
            // ==============================
            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();

            Thread.sleep(2000);
            driver.findElement(By.id("user-name")).sendKeys("standard_user");

            Thread.sleep(1000);
            driver.findElement(By.id("password")).sendKeys("secret_sauce");

            Thread.sleep(1000);
            driver.findElement(By.id("login-button")).click();

            Thread.sleep(3000);
            System.out.println("✅ SauceDemo login done");

            // ==============================
            // TAB 2: AutomationExercise
            // ==============================
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("https://automationexercise.com/");

            Thread.sleep(5000);

            // Hide ads (iframe fix)
            ((JavascriptExecutor) driver).executeScript(
                "document.querySelectorAll('iframe').forEach(el => el.style.display='none');"
            );

            Thread.sleep(2000);

            // Click Add to Cart using JS
            WebElement addToCart = driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[1]"));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCart);
            Thread.sleep(2000);

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCart);

            Thread.sleep(4000);

            driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();

            System.out.println("✅ Product added to cart");

            // ==============================
            // TAB 3: Practice Test Login
            // ==============================
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("https://practicetestautomation.com/practice-test-login/");

            Thread.sleep(2000);
            driver.findElement(By.id("username")).sendKeys("student");

            Thread.sleep(1000);
            driver.findElement(By.id("password")).sendKeys("Password123");

            Thread.sleep(1000);
            driver.findElement(By.id("submit")).click();

            Thread.sleep(3000);
            System.out.println("✅ PracticeTest login done");

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        } finally {
            if (driver != null) {
                Thread.sleep(3000);
                driver.quit();
            }
        }
    }
}
