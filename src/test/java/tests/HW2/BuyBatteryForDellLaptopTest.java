package tests.HW2;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byPartialLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


class BuyBatteryForDellLaptopTest {
    @Test
    void buyBatteryForDellLaptop() {
        //open dell.com
        open("https://www.dell.com/en-us");

        //laptop model
        String notebookModel = "E5570";

        //find search field, and fill with laptop model
        $(".mh-search-input")
                .setValue(notebookModel);
        //click search
        $(".mh-search-button-label").click();
        //find notebook battery checkbox and click on it
        $(withText("Notebook Battery")).click();
        //find any available battery
        $(byPartialLinkText("Battery")).click();
        //add this battery to cart
        $(byPartialLinkText("Add to Ca")).click();
    }
}

