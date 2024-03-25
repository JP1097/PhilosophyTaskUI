import org.openqa.selenium.WebDriver;
import java.util.Objects;

public class WikiPhilosophyNavigationApp extends BasePage {
    public static void main(String[] args) {
        DriverManager driverManager = new DriverManager();
        WebDriver driver = driverManager.getDriver();
        WikipediaPage page = new WikipediaPage(driver);
        String URL = "https://en.wikipedia.org/wiki/Special:Random";

        driver.get(URL);
        int redirects = 0;

        while (!Objects.equals(page.getURL(), "https://en.wikipedia.org/wiki/Philosophy")) {
            String redirectMessage = "Redirects: " + redirects + " | Current page: " + page.getTitle() + " " + page.getURL();
            page.clickFirstLink();
            redirects++;
            System.out.println(redirectMessage);
            if (redirects > 50) {
                driver.get(URL);
                redirects = 0;
                System.out.println("Resetting counter and starting over.");
            }
        }

        System.out.println("Total redirects: " + redirects + " | Current page: " + page.getTitle() + " " + page.getURL());
        sleep(1000);
        driverManager.closeDriver();
    }
}