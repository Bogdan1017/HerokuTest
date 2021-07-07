import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Main {
    public static void main(String[] args){


    }



    public void dynamicElement(){
        //TO DO add a test which goes to http://the-internet.herokuapp.com/entry_ad URL and closes the pop-up
        //then it clicks `click here.` link and checks `THIS IS A MODAL WINDOW` text is displayed on the page

        System.setProperty("webdriver.chrome.driver", "D:\\ХоромДрайвер\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/entry_ad");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement close = driver.findElement(By.xpath("//p[text()='Close']"));
        close.click();
        WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click here']"));
        clickHere.click();

    }


    public void testInvalidLogin(){
        //TO DO add a test which goes to http://the-internet.herokuapp.com/login URL and fills in incorrect details
        //then it clicks `Login` button
        //Here should be a check on error message is displayed on the page

        System.setProperty("webdriver.chrome.driver", "D:\\ХоромДрайвер\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/login");
        WebElement elUsername = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement elPassword = driver.findElement(By.xpath("//input[@name='password']"));
        elUsername.sendKeys("KSKLlndan123");
        elPassword.sendKeys("sdvf324f");
        WebElement  elLogin = driver.findElement(By.xpath("//button[text()=' Login']"));
        elLogin.click();

    }


    public void testValidLogin(){
        //TO DO add a test which goes to http://the-internet.herokuapp.com/login URL and fills in correct details
        //then it clicks `Login` button
        //Here should be a check that user is logged in and a new content is displayed

        System.setProperty("webdriver.chrome.driver", "D:\\ХоромДрайвер\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/login");
        WebElement elUsername = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement elPassword = driver.findElement(By.xpath("//input[@name='password']"));
        elUsername.sendKeys("tomsmith");
        elPassword.sendKeys("SuperSecretPassword!");
        WebElement  elLogin = driver.findElement(By.xpath("//button[text()=' Login']"));
        elLogin.click();


    }


    public void testDynamicLoadingElement() {
        //TO DO add a test which goes to  http://the-internet.herokuapp.com/dynamic_loading/1 URL and
        //clicks start button
        //Here should be a check that Hello World text is displayed

        System.setProperty("webdriver.chrome.driver", "D:\\ХоромДрайвер\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement element = driver.findElement(By.xpath("//button[text() ='Start']"));
        element.click();

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean isDisplayed ;
       if(driver.findElement(By.linkText("Hello Hello")).isDisplayed()){
           isDisplayed = true;
       }else
           isDisplayed = false;

       System.out.println(isDisplayed);


    }


    public void testDownloadFile(){
        //TO DO add a test which goes to http://the-internet.herokuapp.com/jqueryui/menu URL and
        //goes to Enabled-Download-Excel and clicks it
        //verify that the file is downloaded

        System.setProperty("webdriver.chrome.driver", "D:\\ХоромДрайвер\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/jqueryui/menu");
        WebElement elEnabled = driver.findElement(By.xpath("//a[@id = 'ui-id-2'"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elEnabled).build().perform();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement elDownload = driver.findElement(By.xpath("//a[@id = 'ui-id-4'"));
        actions.moveToElement(elDownload).build().perform();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement elExcel = driver.findElement(By.xpath("//a[@id = 'ui-id-8'"));
        elExcel.click();

    }
}
