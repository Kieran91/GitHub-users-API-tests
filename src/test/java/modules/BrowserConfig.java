package modules;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.springframework.beans.factory.annotation.Autowired;

import spring.TestState;

public class BrowserConfig {

	@Autowired
	private TestState state;
	
    public void openBrowser() throws MalformedURLException {
    	
    	String browser = System.getProperty("BROWSER");
        if(browser==null)
        {
            browser = System.getenv("BROWSER");
            if(browser==null)
            {
            	browser = "chrome";
//            	browser = "firefox";
//            	browser = "safari";
            }
        }

        setChromeDriverLocation();
        setFirefoxDriverLocation();


        switch (browser)
        {
            case "chrome":
            	state.setDriver(new ChromeDriver());
                break;
            case "firefox":
            	state.setDriver(new FirefoxDriver());
                break;
            case "safari":
            	SafariOptions options = new SafariOptions();
                options.setUseTechnologyPreview(true); // If true, the SafariDriver will use the Safari Technology Preview, otherwise will use the release version of Safari.
                state.setDriver(new SafariDriver(options));
                break;
            default:
            	state.setDriver(new ChromeDriver());
                break;
        }

        System.out.println("Opening "+browser+" browser.");
        state.getDriver().manage().deleteAllCookies();
        state.getDriver().manage().window().maximize();
        state.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
	
    private void setChromeDriverLocation() {
    	System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
	}
    
    private void setFirefoxDriverLocation() {
    	System.setProperty("webdriver.gecko.driver", "src/test/resources/webdrivers/geckodriver");
	}
    

	
	
	
}
