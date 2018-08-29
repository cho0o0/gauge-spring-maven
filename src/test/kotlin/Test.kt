import com.gargoylesoftware.htmlunit.Page
import com.thoughtworks.gauge.Step
import io.github.cho0o0.gaugespringmaven.ProfileController
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.test.web.servlet.setup.SharedHttpSessionConfigurer.sharedHttpSession
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder
import org.springframework.web.context.WebApplicationContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder
import com.thoughtworks.gauge.Table


class Test {
    @Autowired
    private lateinit var context: WebApplicationContext

    @Step("プロフィール画面にいます")
    fun testProfilePage() {
        val action = get("/profile")
        val mockMvc: MockMvc = MockMvcBuilders.standaloneSetup(ProfileController())
                .apply<StandaloneMockMvcBuilder>(sharedHttpSession())
                .build()
        mockMvc.perform(action).andExpect(status().is2xxSuccessful)
    }

    @Step("歓迎メッセージが表示される <table>")
    fun testWelcomeMessage(table: Table) {
//        val webClient = MockMvcWebClientBuilder
//                .webAppContextSetup(context)
//                .build()
//        val page: Page = webClient.getPage<Page>("http://localhost:8080/profile?name=test")
//        assert(page.isHtmlPage)
    }
}
