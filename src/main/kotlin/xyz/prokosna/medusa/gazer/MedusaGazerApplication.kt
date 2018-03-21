package xyz.prokosna.medusa.gazer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class MedusaGazerApplication

fun main(args: Array<String>) {
    runApplication<MedusaGazerApplication>(*args)
}
