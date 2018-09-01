package base

import org.apache.logging.log4j.LogManager
import org.openqa.selenium.Platform
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import java.net.URL
import java.util.concurrent.TimeUnit


abstract class TestBase {
    private val logger = LogManager.getLogger(TestBase::class.java)

    lateinit var driver: WebDriver
        private set

    @BeforeTest
    fun setUp() {
        val capabilities = DesiredCapabilities()
        val hubURL = "http://localhost:4444/wd/hub"
//        System.setProperty("webdriver.chrome.webDriver", "chromedriver")

//        capabilities.setCapability("browserName", "firefox")
        capabilities.setCapability("browserName", "chrome")
        capabilities.setCapability("platformName", Platform.ANDROID)
        capabilities.setCapability("platformName", Platform.LINUX)
        capabilities.setCapability("deviceName", "OnePlus Two")
//        capabilities.setCapability("appWaitActivity", "SplashActivity, SplashActivity,OtherActivity, *, *.SplashActivity")
//        capabilities.setCapability("appPackage", "com.android.chrome")
//        capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main")
//        capabilities.setCapability("platformName", Platform.ANDROID)


        driver = RemoteWebDriver(URL(hubURL), capabilities)
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
        logger.trace("Initialising $driver")
    }

    @AfterTest
    fun tearDown() {
        logger.trace("Closing driver ($driver)")
        driver.quit()
    }

}