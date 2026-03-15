package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class App {

    public static void main(String[] args) {

        FirefoxOptions options = new FirefoxOptions();

        options.setBinary("/snap/firefox/current/usr/lib/firefox/firefox");

        WebDriver driver = new FirefoxDriver(options);

        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();

        driver.findElement(By.linkText("Signup / Login")).click();

        driver.findElement(By.name("email")).sendKeys("roch.phutane@gmail.com");

        driver.findElement(By.name("password")).sendKeys("Splash12345#");

        driver.findElement(By.xpath("//button[text()='Login']")).click();

        driver.quit();
    }
}
