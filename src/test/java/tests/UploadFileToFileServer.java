package tests;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class UploadFileToFileServer {
    @Test
    void uploadSomeFile(){


        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();



        File file = new File("F:\\selenide\\src\\test\\java\\resources\\enot.jpg");

        driver.get("https://ru.files.fm/");
        driver.findElement(By.id("uploadifive-file_upload")).sendKeys("F:/selenide/src/test/java/resources/enot.jpg");
   //     $(By.id("simple_file_select_button")).uploadFromClasspath("F:\\selenide\\src\\test\\java\\resources\\enot.jpg");;


      //  File file = new File("F:/selenide/src/test/java/resources/enot.jpg");
      //  $("#file").input(file);

    }

}
