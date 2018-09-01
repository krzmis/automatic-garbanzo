package gitHub

import base.TestBase
import org.apache.logging.log4j.LogManager
import org.testng.asserts.SoftAssert
import pages.GitHubMainPage

open class GitHubTestHelpers : TestBase() {

    private val logger = LogManager.getLogger(GitHubTestHelpers::class.java)
    val softAssert = SoftAssert()

    fun checkMainPageTitle() {
        val mainPage = GitHubMainPage(super.driver)
        mainPage.open()

        val expectedTitle = "The world’s leading software development platform · GitHub"
        val actualTitle = mainPage.getPageTitle()
        val condition = actualTitle == expectedTitle
        val message: String?

        message = if (condition) {
            "Actual title '$actualTitle' match expected title '$expectedTitle'"
        } else {
            "Actual title '$actualTitle' does NOT match expected title '$expectedTitle'"
        }

        softAssert.assertTrue(condition, message)
        logger.debug(message)

    }
}