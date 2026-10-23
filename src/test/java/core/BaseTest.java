package core;

import constants.DriverConfig;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUp() {
        initDriver(System.getProperty(DriverConfig.BROWSER_PROPERTY, DriverConfig.BROWSER_CHROME));
    }

    private void initDriver(String browser) {
        driver = DriverFactory.createDriver(browser);
    }

    @After
    public void tearDown() {
        quitDriver();
    }

    private void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
