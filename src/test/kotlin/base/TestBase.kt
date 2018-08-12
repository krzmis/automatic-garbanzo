package base

import org.apache.logging.log4j.LogManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import java.util.concurrent.TimeUnit

abstract class TestBase {
    private val logger = LogManager.getLogger(TestBase::class.java)

    lateinit var driver: WebDriver
        private set

    @BeforeTest
    fun setUp() {
        val capabilities = DesiredCapabilities()

//        System.setProperty("webdriver.chrome.webDriver", "chromedriver")
        System.setProperty("webdriver.chrome.webDriver", "chromedriver")
        capabilities.browserName = "chrome"

        driver = ChromeDriver() as WebDriver
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
        logger.trace("Initialising $driver")
    }

    @AfterTest
    fun tearDown() {
        logger.trace("Closing driver ($driver)")
        driver.quit()
    }

}