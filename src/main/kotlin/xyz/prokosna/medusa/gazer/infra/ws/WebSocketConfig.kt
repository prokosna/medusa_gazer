package xyz.prokosna.medusa.gazer.infra.ws

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.HandlerMapping
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping
import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter

@Configuration
open class WebSocketConfig(private val dashboardHandler: DashboardHandler) {
    @Bean
    open fun webSocketMapping(): HandlerMapping {
        val map = HashMap<String, WebSocketHandler>()
        map.put("/dashboard", dashboardHandler)

        val mapping = SimpleUrlHandlerMapping()
        mapping.urlMap = map
        mapping.order = -1
        return mapping
    }

    @Bean
    open fun handlerAdaptor(): WebSocketHandlerAdapter {
        return WebSocketHandlerAdapter()
    }
}