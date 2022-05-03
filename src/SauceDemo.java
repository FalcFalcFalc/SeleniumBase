import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SauceDemo {

    static By  userField = By.xpath("//*[@id='user-name']"),
        passField = By.xpath("//*[@id='password']"),
        loginBTN  = By.xpath("//*[@id='login-button']");

    static String  url = "https://www.saucedemo.com/",
            user = "standard_user",
            pass = "secret_sauce";

    WebDriver driver;

    public static void main(String[] args){

    }

    @BeforeTest
    void setUp(){
        String chromeDriverDirectory =  "C:\\Users\\juani\\Documents\\GitHub\\SeleniumBase\\chromedriver.exe";
        
        //Disculpen por haber hardcodeado la direccion del chrome driver, pero sinceramente
        //no encontré una forma más prolija de resolver este problema, para ejecutarlo y probar
        //que esto funcione, van a tener que actualizar la direccion del archivo en el codigo.
        //Utilizando estos métodos para conseguir el path absoluto del proyecto, me terminó
        //mandando al appdata.
        
        //FileSystems.getDefault().getPath("").toAbsolutePath().toString() + "\\chromedriver.exe"
        //System.getProperty("user.dir") + "\\chromedriver.exe"
        System.setProperty("webdriver.chrome.driver", chromeDriverDirectory);
    }

    @Test
    public void loginToPage() throws Exception {

        driver = new ChromeDriver();

        driver.navigate().to(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        System.out.println("Accessed URL");

        driver.findElement(userField).sendKeys(user);
        Assert.assertEquals(driver.findElement(userField).getAttribute("value"), user);
        System.out.println("Sent USER");

        driver.findElement(passField).sendKeys(pass);
        Assert.assertEquals(driver.findElement(passField).getAttribute("value"), pass);
        System.out.println("Sent PASS");

        driver.findElement(loginBTN).click();
        System.out.println("Clicked Login");
        
        Thread.sleep(1000);
        System.out.println("Everything worked out");

        driver.quit();
    }
}
