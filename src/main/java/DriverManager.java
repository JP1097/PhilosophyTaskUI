import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class DriverManager {
    private final WebDriver driver;
    public DriverManager() {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/Caskroom/chromedriver/122.0.6261.111/chromedriver-mac-arm64/chromedriver");
        driver = new ChromeDriver();

    }
    public WebDriver getDriver(int seconds) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        return driver;
    }
    public WebDriver getDriver() {
        getDriver(3);
        return driver;
    }
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
