package xyz.prokosna.medusa.gazer.infra.rest

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
open class Router(private val helloHandler: HelloHandler) {
    @Bean
    open fun apis() = router {
        (accept(MediaType.APPLICATION_JSON).nest {
            GET("/hello", helloHandler::getHello)
        })
    }
}
