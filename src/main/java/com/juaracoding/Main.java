package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\MyTools\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize(); //agar tampilan maksimal
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://shop.demoqa.com/my-account/"); //test di web shop demoqa bagian my account
        System.out.println("open browser");

        //registrasi
        driver.findElement(By.xpath("//*[@id=\"reg_username\"]")).sendKeys("salmanida");
        driver.findElement(By.name("email")).sendKeys("salmanida@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"reg_password\"]")).sendKeys("qwerty123456");
        driver.findElement(By.name("register")).click();
        System.out.println("registered.");

        delay(3);

        driver.quit();
        System.out.println("close browser");


    }
    static void delay(long detik) {
        try { //jeda sebelum close
            Thread.sleep(detik*1000);
        } catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}