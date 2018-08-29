package io.github.cho0o0.gaugespringmaven

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class ProfileController {

    @GetMapping("/profile")
    fun greeting(@RequestParam(name = "name", required = false, defaultValue = "Cyan") name: String, model: Model): String {
        model.addAttribute("name", name)
        return "profileView"
    }

}