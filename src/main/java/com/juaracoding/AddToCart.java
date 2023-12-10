package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AddToCart {
    public static void main(String[] args) {
        String path = "C:\\MyTools\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize(); //agar tampilan maksimal
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://shop.demoqa.com/product/pink-drop-shoulder-oversized-t-shirt/");
        System.out.println("open browser");

        //scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
        System.out.println("scroll vertical 600px");

        //select color
        delay(3);
        WebElement selectColor = driver.findElement(By.xpath("//*[@id=\"pa_color\"]"));
        Select slcColor = new Select(selectColor);
        slcColor.selectByIndex(1);
        System.out.println("color selected");

        //select size
        delay(3);
        WebElement selectSize = driver.findElement(By.xpath("//*[@id=\"pa_size\"]"));
        Select slcSize = new Select(selectSize);
        slcSize.selectByIndex(3);
        System.out.println("size selected");

        //add count
        WebElement addProduct = driver.findElement(By.xpath("//*[@id=\"product-1497\"]/div[1]/div[2]/form/div/div[2]/div/div/button[2]"));
        addProduct.click();
        System.out.println("count added");

        //button add to cart
        delay(3);
        WebElement btnCart = driver.findElement(By.xpath("//*[@id=\"product-1497\"]/div[1]/div[2]/form/div/div[2]/button"));
        btnCart.click();
        System.out.println("product added to Cart.");

        //validation test case positive
        delay(3);
        WebElement txtCart = driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div/div/div[1]/div"));
        String getTxtCart = txtCart.getText();
        if (getTxtCart.contains("added")){
            System.out.println("passed");
        } else {
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
