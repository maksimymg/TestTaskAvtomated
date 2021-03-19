import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {
    WebDriver driver;
    @BeforeTest
    public void preConditions() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Start Browser");

        System.out.println("Open website");
        driver.get("http://computer-database.gatling.io/computers/");
    }
    @AfterTest
    public void postConditions() throws InterruptedException {
        System.out.println("Close browser");
        Thread.sleep(3000);
        if (driver != null)
        driver.quit();
    }

    @Test
    public void Test1() throws InterruptedException {

        System.out.println("Click to 'Add a new computer ");
        Thread.sleep(1000);
        driver.findElement(By.id("add")).click();

        System.out.println("Computer name");
        Thread.sleep(1000);
        driver.findElement(By.id("name")).sendKeys("AB Soft");

        System.out.println("Introduced");
        Thread.sleep(1000);
        driver.findElement(By.id("introduced")).sendKeys("2011-03-17");

        System.out.println("Discontinued");
        Thread.sleep(1000);
        driver.findElement(By.id("discontinued")).sendKeys("2021-03-17");

        System.out.println("Company");
        Thread.sleep(1000);
        driver.findElement(By.id("company")).click();
        driver.findElement(By.xpath("//*[@id=\"company\"]/option[16]")).click();

        System.out.println("Create this computer");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input.btn.primary")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]")).getText().equalsIgnoreCase("Done ! Computer AB Soft has been created"));
    }
    @Test
    public void Test2() throws InterruptedException {
            System.out.println("Filter by name");
            Thread.sleep(1000);
            driver.findElement(By.id("searchbox")).sendKeys("AB Soft");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"searchsubmit\"]")).click();
            Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"main\"]/h1")).getText().equalsIgnoreCase("One computer found"));
        }






}
