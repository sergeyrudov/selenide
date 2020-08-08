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

class UploadFileToFileServer {
    @Test
    void uploadSomeFile(){
    Configuration.holdBrowserOpen = true;

    File file = new File("F:\\selenide\\src\\test\\java\\resources\\enot.jpg");

    open("https://ru.files.fm/");
    $(By.id("uploadifive-file_upload")).uploadFile(file);;


      //  File file = new File("F:/selenide/src/test/java/resources/enot.jpg");
      //  $("#file").input(file);

    }

}
