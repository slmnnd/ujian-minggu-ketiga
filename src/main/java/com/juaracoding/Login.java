package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    public static void main(String[] args) {
        String path = "C:\\MyTools\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize(); //agar tampilan maksimal
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://shop.demoqa.com/my-account/");
        System.out.println("open browser");

        //form login
        delay(3);
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("salmanida");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("qwerty123456");

        //remember me
        delay(3);
        driver.findElement(By.xpath("//*[@id=\"rememberme\"]")).click();
        System.out.println("remember me checked");

        //button login
        delay(3);
        WebElement btnLogin = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/button"));
        btnLogin.click();
        System.out.println("login successfully.");

        //validation test case positive
        delay(3);
        WebElement txtLogin = driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/div/p[1]"));
        String getTxtLogin = txtLogin.getText();
        if(getTxtLogin.contains("Hello")){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }

        delay(3);

        driver.quit();
        System.out.println("close browser");


    }

    static void delay(long detik) {
        try { //jeda sebelum close
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
