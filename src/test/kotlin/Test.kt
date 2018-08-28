import com.thoughtworks.gauge.Step

import junit.framework.TestCase.assertTrue
import utils.driver.Driver

class Test {
    @Step("プロフィール画面にいます")
    fun implementation1() {
        Driver.webDriver.get("localhost:8080")
        assertTrue(true)
    }
}
