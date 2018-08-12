package pages

import org.apache.logging.log4j.LogManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.How


class GitHubMainPage(private val driver: WebDriver) {
    private val logger = LogManager.getLogger(GitHubMainPage::class.java)
    private val mainPageURL = "https://github.com/"

    init {
        PageFactory.initElements(driver, this)
    }

    fun open() {
        driver.get(mainPageURL)
        logger.trace("Navigating to $mainPageURL")
    }

    fun getPageTitle(): String? {
        return driver.title
    }

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Search or jump to…']")
    private val searchBar: WebElement? = null

}