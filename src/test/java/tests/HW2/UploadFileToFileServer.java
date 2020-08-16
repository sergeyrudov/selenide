package tests.HW2;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


class UploadFileToFileServer {
    @Test
    void uploadSomeFile(){
    File file = new File("src\\test\\java\\resources\\enot.jpg");
    open("https://ru.files.fm/");
    $("#uploadifive-file_upload input", 1).uploadFile(file);
    $("#savefiles").click();
    $(".upload_button").click();
    }
}
