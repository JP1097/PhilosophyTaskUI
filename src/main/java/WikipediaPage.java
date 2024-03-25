import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikipediaPage {
    private final WebDriver driver;
    private final By firstLinkSelector = By.xpath("(//div[@id='mw-content-text']//p[not(ancestor::table)]/a[not(ancestor::sup) and not(contains(@href, ':')) and not(contains(@class, 'new'))])[1]");
    private final By firstLinkSelectorDifferent = By.xpath("(//div[@id='mw-content-text']//a[@href])[1]");
    public WikipediaPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickFirstLink(){
        try {
            WebElement firstLink = driver.findElement(firstLinkSelector);
            firstLink.click();
        } catch (Exception e) {
            System.out.println("Using second xpath to locate first link.");
            WebElement firstLinkOther = driver.findElement(firstLinkSelectorDifferent);
            firstLinkOther.click();
        }
    }
    public String getURL(){
        return driver.getCurrentUrl();
    }
    public String getTitle(){
        return driver.getTitle();
    }
}