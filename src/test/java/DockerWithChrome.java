import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DockerWithChrome {
    static String nodeUrl;
    public static void main(String[] args) throws MalformedURLException {

        nodeUrl = "http://localhost:4545/wd/hub";

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(ChromeOptions.CAPABILITY, options);
        dc.setBrowserName("chrome");
        dc.setPlatform(Platform.WINDOWS);
        RemoteWebDriver driver = new RemoteWebDriver(new URL(nodeUrl), dc);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        System.out.println("Title of the page" + driver.getTitle());
        driver.quit();

    }
}
