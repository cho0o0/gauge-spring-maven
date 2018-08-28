package io.github.cho0o0.gaugespringmaven

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GaugeSpringMavenApplication

fun main(args: Array<String>) {
    runApplication<GaugeSpringMavenApplication>(*args)
}
