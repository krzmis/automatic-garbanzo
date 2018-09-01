package gitHub

import org.testng.annotations.Test

class GitHubTest : GitHubTestHelpers() {

    @Test
    fun runTestOnMainPage() {
        checkMainPageTitle()
        softAssert.assertAll()
    }

}