package com.nextbasecrm.test;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US_12 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



        //1-User on the homepage
        driver.get("https://login2.nextbasecrm.com/");
        CRM_Utilities.crm_login(driver);
    }






    @Test
    public void announcement_set_Up() throws InterruptedException {
        //********* more dropdown feature ******************
        WebElement moreDropDown = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']"));
        moreDropDown.click();


        //******** Announcement option is located and clicked
        WebElement announcementOption = driver.findElement(By.xpath("//span[.='Announcement']"));
        announcementOption.click();


        //************ Message Editor is located (identified) and write the text down in it
        // this text editor is located in iframe
        WebElement frameElm = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
        driver.switchTo().frame(frameElm);



        WebElement msgEditor = driver.findElement(By.xpath("//body[@contenteditable='true']"));
        msgEditor.sendKeys("CyberTek");


        driver.switchTo().defaultContent();

        //********* Send Button is located and clicked
        WebElement sendBtn = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendBtn.click();



        //Message should appear


        WebElement message=driver.findElement(By.xpath("//div[starts-with(@id,'blog_post_body')]"));



        String expected="CyberTek";
        String actual= message.getText();
        Assert.assertEquals(actual,expected);






    }

    @Test
    public void announcement_set_up() throws InterruptedException {
        //********* more dropdown feature ******************
        WebElement moreDropDown = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']"));
        moreDropDown.click();
        Thread.sleep(2000);

        //******** Announcement option is located and clciked
        WebElement announcementOption = driver.findElement(By.xpath("//span[.='Announcement']"));
        announcementOption.click();


        WebElement sendButton=driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();
        //verify if the message title is not specified is displayed
        WebElement error= driver.findElement(By.xpath("//*[text()='The message title is not specified']"));
        Assert.assertTrue(error.isDisplayed());

        String expectedText="The message title is not specified";
        String actualText=error.getText();
        Assert.assertEquals(actualText,expectedText);


    }

    @AfterMethod
    public void tearDown()  {

        driver.quit();
    }


}
