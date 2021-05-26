package utils;

import org.openqa.selenium.By;

public interface Locators {
    String url = "https://pandakindermoebel.ch/mein-konto/";
    //String mail= "TechnoGttrwewro11@gmail.com";
   // String password= "A8df6181ed.a";
    String userName= "Grooewu1.";


    By akzeptiereButton =By.xpath("//span[text()='Akzeptiere alle']");
    By registerButton=By.cssSelector("a#bb-show-register-button");
    By regUserNameInput=By.cssSelector("#reg_username");
    By regMailInput=By.cssSelector("#reg_email");
    By regPasswordInput=By.cssSelector("#reg_password");
    By createCustomerButton=By.cssSelector("p.form-actions.woocommerce-form-row");
    By helloText = By.cssSelector("h1.page-title");

    By kontoDetails= By.xpath("//a[text()='Kontodetails']");
    By editAccountInput= By.cssSelector("input.woocommerce-Input.woocommerce-Input--text.input-text");
    By editPassInput= By.cssSelector("input.woocommerce-Input.woocommerce-Input--password.input-text");
    By saveChangesButton=By.cssSelector("button.woocommerce-Button.button");
    By successfullyMessage=By.cssSelector("div.woocommerce-message");
    By menuItems=By.cssSelector("nav>ul>li[id^='menu-item-']");
}

