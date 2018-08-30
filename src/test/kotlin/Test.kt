import com.thoughtworks.gauge.*
import io.github.bonigarcia.wdm.ChromeDriverManager
import junit.framework.TestCase.assertFalse
import org.junit.After
import org.junit.Before
import org.junit.BeforeClass
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.springframework.boot.web.server.LocalServerPort

class Test {
//    @Autowired
//    private lateinit var context: WebApplicationContext

    private lateinit var driver: WebDriver

    @LocalServerPort
    private val port: Int = 8080

    @BeforeSpec
    @BeforeClass
    @Throws(Exception::class)
    fun setUpClass() {
        ChromeDriverManager.getInstance().setup()
    }

    @Before
    @BeforeScenario
    @Throws(Exception::class)
    fun setUp() {
        driver = ChromeDriver()
    }

    @After
    @AfterScenario
    fun tearDown() {
        driver.close()
    }

//    @Step("プロフィール画面にいます")
//    fun testProfilePageAlter() {
//        val action = get("/profile")
//        val mockMvc: MockMvc = MockMvcBuilders.standaloneSetup(ProfileController())
//                .apply<StandaloneMockMvcBuilder>(sharedHttpSession())
//                .build()
//        mockMvc.perform(action).andExpect(status().is2xxSuccessful)
//    }

    @Step("プロフィール画面にいます")
    fun testProfilePage() {
        driver.navigate().to("http://localhost:$port/profile?name=test")
    }

    @Step("歓迎メッセージが表示される <table>")
    fun testWelcomeMessage(table: Table) {
        val body: WebElement = driver.findElement(By.tagName("body"))
        val bodyText: String = body.text
        val possibleMessages: List<String> = table.getColumnValues("歓迎メッセージ")
        assertFalse(possibleMessages.filter { bodyText.contains(it) }.isEmpty())
    }
}
