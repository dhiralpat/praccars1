/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test.com.sears.homeservice;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author dpate
 */
public class carsTest {
    private WebDriver driver;
   
    public carsTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testPartsSearch() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\data\\chromedriver.exe");  
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //fluent wait
        driver.get("https://www.cars.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"mobile-menu-section\"]/ul[1]/li[5]/a")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 1000)");
        driver.findElement(By.xpath("//*[@id=\"ae-main-content\"]/div[2]/section[8]/div/div[2]/a")).click();
        js.executeScript("window.scrollTo(0, 2000)");
        driver.findElement(By.xpath("//*[@id=\"ae-main-content\"]/div[2]/section[2]/div[1]/div/div[9]/ul/li[1]/a")).click();
        String response = driver.findElement(By.xpath("//*[@id=\"ae-main-content\"]/div[2]/section[1]/header/h1")).getText();
        assertEquals ("Automatic Transmission",response);
    }
}
