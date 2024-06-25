package com.ch1kkgq;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

class DemoGuru99Test {

    private static WebDriver myBrowser;

    @BeforeAll  //Hàm này sẽ chạy trc tất cả các hàm @Test khác
    //Nó hay dùng để thiết lập môi trường, khởi động các biến...
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--lang=en-GB");
        myBrowser = new ChromeDriver(options);
        myBrowser.manage().window().maximize();

    }

    //Các Test case sẽ nằm trong hàm có @Test, ko care thứ tự với @BeforeAll, @AfterAll
    @Test
    public void testDemoGuru99GivenRightManagerAccountRunsWell() throws InterruptedException {
        myBrowser.get("https://demo.guru99.com/v4/");

        //query các tag để tìm
        WebElement txtLogin = myBrowser.findElement(By.xpath("//input[@name='uid']"));
        txtLogin.sendKeys("mngr577301");
        WebElement txtPassword = myBrowser.findElement(By.xpath("//input[@name='password']"));
        txtPassword.sendKeys("hyjasUh");

        WebElement btnLogin = myBrowser.findElement(By.xpath("//input[@name='btnLogin']"));
        btnLogin.click();

        //chuyển trang sang trang menu của manager
        //khi chuyển trang phải có WAIT
        //nếu ko lệnh code của mình chạy nhanh hơn trang menu đc tải về
        //WAIT
        Thread.sleep(5000);

        WebElement lblMessage = myBrowser.findElement(By.cssSelector("tr[class='heading3'] td"));
        System.out.println(lblMessage.getText());

        assertEquals(lblMessage.getText(), "Manger Id : mngr577301");
    }
    //Test Case #1: Check DemoDuru99 Login successfully with manager account
    //Steps/Procedures (Các bước thực thi test case - ví đây là test app test chức năng, test màn hình)
    //  1. Open a certain browser, e.g. Chrome or Edge
    //  2. Navigate to Demo Guru99 web app with the url: https://demo.guru99.com/V4/
    //  3. In the login page, input a valid manager account, e.g. mngr577301/ hyjasUh

    //A Welcome message with the format of
    //          "Welcome To Manager'Page ò Guru99"

    //Nếu kịch bản TEST CASE ở trên làm = tay của dân QC (Chạy bằng cơm)
    //Kĩ thuật kiểm thử này gọi là TEST MANUAL, MANUAL TESTING
    //Dân QC: Đọc REQS từ mên SWR để hiểu app cần test
    //      Thiết kế như trên
    //      Run test case - tay, bằng mắt, bằng sức
    //      hoặc giao cho lính mới
    //TEST CASE tạch, app ko trả kq như dự kiến
    //ví dụ Login = account mangager, lộn đi vào màn hình Staff
    //Login sai 5 lần, mà ko khóa account -> bug rồi
    //cập nhật trạng thái TEST CASE tạch, FAILED, ghi BUG lên BUG DB
    //LOG BUG (BUZILLA là tool lưu BUG, JIRA lưu BUG luôn)

    //Dân QC đẳng cấp cao hơn: tự động hóa test case ở trên bằng cách viết code, để tự mở app, tự login (Bỏ qua 2 lớp)
    //      Tự CLICK, tự input, tư verify
    //      SELENIUM hoặc các tool khác để tự động hóa kịch bản TEST CASE
    //      Dân QC phải biết viết code để tự động hóa việc kiểm thử
    //      TEST ko chạy bằng cơm mà chạy = code
    // TEST AUTOMATION, AUTOMATION TESTING, AUTOMATED TESTING

    //Đoạn CODE SELENIUM ta đang viết đc gọi là TEST AUTOMATION SCRIPT TEST SCRIPT
    //TEST SCRIPT đc gọi là đoạn code tự động hóa test case

    //Viết CODE ban đầu khá cực, dân QC đôi khi chơi chiêu:
    //Dùng các tool có sẵn trên mạng, test automation tool
    //KATALON KMS, TELERIK, AK AT (fSoft), JETBRAIN QUA IDE, TEST COMPLETE RANOREX... -> là tool giúp QC RECORD toàn bộ thao tác MANUAL của QC thành CODE, PLAY lại RECORD/PLAYBACK
    //Giúp viết CODE trở nên nhe nhang

    // SEMINAR thứ 2 của môn SWT
    //Chon 1 AUTOMATION tool, bất kì ở trên, hoạc ko
    //DEMO, thuyết trình (TEST 1 app nào đó)

    //Thách thức danh hài: test non-func reqs
    //app chạy nhanh, chậm: tool riêng: JMETER (Giả lập n user cùng xài app)

    //Hoặc có thể dùng code: APPNIUM, PLAYWRIGHT (MS), CYPRESS (JS)
    @AfterAll   //Hàm này chạy 1 lân sau khi tất cả các hàm @Test đã chạy xong, nó hay dùng để dọn dẹp/phục hồi data mà mấy @Test đã lỡ chỉnh sửa trong quá trình run test
    public static void tearDown() throws Exception {
        Thread.sleep(5000);
        myBrowser.quit();
    }
}