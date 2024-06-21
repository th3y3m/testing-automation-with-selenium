package com.ch1kkgq;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import javax.swing.plaf.TableHeaderUI;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    //TEST CASE #1: FUNCTIONAL TESTING - TEST chức năng của APP không TEST hàm (Việc này của dân DEV)
    //      TEST chức năng (xem APP hoạt động ra sao ở góc nhìn USER, góc nhìn xài APP, ko CARE CODE, ko thèm viết CODE)
    //      TEST chúc năng là TEST góc nhìn người dùng
    //      Chơi với UI
    //      Có 2 cách TEST chức năng - Do dân QC dảm nhận
    //Cách 1: Trâu bò dùng sức: CLICK CLICK nhập gì đó hoàn toàn thử công = tay
    //Mở APP = tay, nhấn chuột = tay, nhập INFO = tay, xem kết quả trả về của APP = mắt, và tự kết luận đúng sai
    //Kĩ thuật MANUAL TESTING - chạy bằng cơm của QC

    //Cách 2: Dùng trí, dùng CODE để tự động hóa toàn bộ thao tác = tay của dân QC, dân QC lúc này phải biết viết CODE, OOP luôn nhưng ko cần biết làm APP, chủ đủ dùng để viết
    // CODE làm APP chạy như ma nhập theo kịch bản mình muốn =? TEST AUTOMATION TESTING
    //Dùng thêm thư viện, TOOL bên ngoài

    //Có 3 cách để chơi TEST AUTOMATION
    //1. Dùng TOOL
    //2. Dùng TOOL ra CODE
    //3. CODE       SELENIUM, CYPRESS, PLAYWRIGHT: 3 bộ thư viện nổi tiếng giúp ta điều khiển BROWSER, MOBILE APP, DESKTOP qua code

    //TOOL ở mục 1 chính là xài 3 thằng này

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver myBrowser = new ChromeDriver(options);
        myBrowser.manage().window().maximize();
        myBrowser.get("https://demo.guru99.com/V4/");
        WebElement uid = myBrowser.findElement(By.name("uid"));
        uid.sendKeys("mngr577301");
        WebElement pwd = myBrowser.findElement(By.name("password"));
        pwd.sendKeys("hyjasUh");
        WebElement submit = myBrowser.findElement(By.name("btnLogin"));
        submit.submit();

//        WebElement create = myBrowser.findElement(By.name("create"));

        Thread.sleep(100000);
        myBrowser.quit();

    }
//    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
////        System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
//
////        EdgeOptions options = new EdgeOptions();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--incognito");
//        options.addArguments("--lang=ja-JP");
//
//        WebDriver myBrowser = new ChromeDriver(options);
////        WebDriver myBrowser = new EdgeDriver(options);
//        //myBrowser là biến object trỏ tới trình duyệt - object rất bự
//        //ta muốn trình duyệt làm gì, ta gì myBrowser
//        //Kĩ thuật điều khiển trình duyệt = code ! Giúp dân QC tránh nhàm chán
//        myBrowser.manage().window().maximize();
//        myBrowser.get("https://www.google.com/");
//
//        //đi bắt 1 tag của 1 trình duyệt - định vị - locator
//        //nên nhớ: trong lập trình ÔP mọi thứ đểu là object
//        //Trình duyệt chứa trang Web cũng đang là object bự
//        //chứ bên trong object khác - trang web
//        //trang Web là ọbject - DOM (<html></html>)
//        //                              object
//        //object <html> lại chứa bên trong nhiều object khác
//        //  <head>
//        //      <body>
//        //Object <body? chứ nhiều <tag> <p> <br> <a> <img>
//        //mỗi tag gọi là là 1 object
//        //gọi chung chung là WebElement
//
//        //mò vào object trang Google vừa tải về đi tìm object tương đương ô search
//        WebElement searchBox = myBrowser.findElement(By.name("q"));
//        searchBox.sendKeys("Đừng làm trái tim anh đau");
//        searchBox.submit();
//        Thread.sleep(5000);
//        myBrowser.quit();
//
//
//    }
}