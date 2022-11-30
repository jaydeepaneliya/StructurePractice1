package org.example;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import static org.example.BasePage.driver;

public class DriverManager extends Utils {

    public static final String USERNAME = LoadProperty.getProperty("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_KEY = LoadProperty.getProperty("BROWSERSTACK_ACCESS_KEY");
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    String browserName = LoadProperty.getProperty("browser");
    //    String browserName = System.getProperty("browser");
    boolean runIncloud = Boolean.parseBoolean(LoadProperty.getProperty("cloud"));
    MutableCapabilities capabilities = new MutableCapabilities();



    public void openBrowser(){
        //run in cloud===============================================================================================================================

        if(runIncloud){
            //connect to cloud
            System.out.println("Running on cloud");
            if (browserName.equalsIgnoreCase("Edge")) {
                ///connect with browserstack
                capabilities.setCapability("browserName", "Edge");
                capabilities.setCapability("browserVersion", "106.0");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "10");
                browserstackOptions.put("local", "false");
                browserstackOptions.put("seleniumVersion", "4.1.0");
                capabilities.setCapability("bstack:options", browserstackOptions);

            } else if (browserName.equalsIgnoreCase("Firefox"))
            {
                ///connect with browserstack
                capabilities.setCapability("browserName", "firefox");
                capabilities.setCapability("browserVersion", "106.0");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "11");
                browserstackOptions.put("local", "false");
                browserstackOptions.put("seleniumVersion", "4.1.0");
                capabilities.setCapability("bstack:options", browserstackOptions);
            } else {
                System.out.println("Your browser name is wrong or missing implementation:" + browserName);
            }
            try {
                driver = new RemoteWebDriver(new URL(URL), capabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }

        }else{
            //run locally
            System.out.println("Running locally");
            if(browserName.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe"); //Assigned a chrome browser
                driver=new ChromeDriver(); //Created a driver object
            } else if (browserName.equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.edge.driver", "src/test/java/drivers/msedgedriver.exe"); //Assigned an edge browser
                driver = new EdgeDriver(); //Created a driver object
            }
            else if (browserName.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/test/java/drivers/geckodriver.exe"); //Assigned a firefox browser
                driver = new FirefoxDriver(); //Created a driver object
            }
            else{
                System.out.println("Your browser name is wrong or missing implementation:" + browserName);
            }

        }




//        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe"); //Assigned a chrome browser
//        driver=new ChromeDriver(); //Created a driver object
        driver.get(LoadProperty.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().fullscreen();
    }

    public void closeBrowser(){

        driver.quit();

    }

}
