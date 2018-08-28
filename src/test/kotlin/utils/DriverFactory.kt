package utils.driver

import io.github.bonigarcia.wdm.ChromeDriverManager
import io.github.bonigarcia.wdm.FirefoxDriverManager
import io.github.bonigarcia.wdm.InternetExplorerDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver

object DriverFactory {

    // Get a new WebDriver Instance.
    // There are various implementations for this depending on browser. The required browser can be set as an environment variable.
    // Refer http://getgauge.io/documentation/user/current/managing_environments/README.html
    val driver: WebDriver
        get() {

            val browser = System.getenv("BROWSER")
            if (browser == null) {
                ChromeDriverManager.getInstance().setup()
                return ChromeDriver()
            }
            when (browser) {
                "IE" -> {
                    InternetExplorerDriverManager.getInstance().setup()
                    return InternetExplorerDriver()
                }
                "FIREFOX" -> {
                    FirefoxDriverManager.getInstance().setup()
                    return FirefoxDriver()
                }
                else -> {
                    ChromeDriverManager.getInstance().setup()
                    return ChromeDriver()
                }
            }
        }
}