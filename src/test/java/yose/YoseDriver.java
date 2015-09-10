package yose;

import com.objogate.wl.UnsynchronizedProber;
import com.objogate.wl.web.AsyncWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import yose.pages.HomePage;

import java.io.IOException;
import java.util.List;

public class YoseDriver {
    private final Yose yose;
    private AsyncWebDriver browser;
    private final FirefoxDriver driver;

    public YoseDriver(int port) {

        this.yose = new Yose(port);
        this.driver = new FirefoxDriver();
    }

    private AsyncWebDriver browser() {
        if (browser == null) {
            browser = new AsyncWebDriver(new UnsynchronizedProber(), this.driver);
        }
        return browser;
    }

    public void start() throws IOException {
        yose.start();
    }

    public void stop() throws IOException {
        yose.stop();
        if (browser != null) browser.quit();
    }

    public boolean findIdentifier(String identifier) {
        browser().navigate().to(url("/"));
        String sourceCode = driver.getPageSource();
        List<WebElement> resultElements = driver.findElements(By.id(identifier));
        return (!resultElements.isEmpty());
    }

    public HomePage home() {
        browser().navigate().to(url("/"));
        return new HomePage(browser);
    }

    private String url(String path) {
        return yose.uri().resolve(path).toASCIIString();
    }


}