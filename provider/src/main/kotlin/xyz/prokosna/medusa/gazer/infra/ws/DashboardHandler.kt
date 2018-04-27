package xyz.prokosna.medusa.gazer.infra.ws

import org.springframework.core.io.buffer.DataBufferFactory
import org.springframework.stereotype.Component
import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.WebSocketMessage
import org.springframework.web.reactive.socket.WebSocketSession
import reactor.core.publisher.Mono
import xyz.prokosna.medusa.gazer.app.service.FooService
import java.time.Duration

@Component
class DashboardHandler(private val fooService: FooService) : WebSocketHandler {

    override fun handle(session: WebSocketSession): Mono<Void> {
        return session.send(session.receive()
                .delaySubscription(Duration.ofSeconds(2L))
                .map { msg -> msg.payloadAsText }
                .mergeWith(fooService.emit())
                .flatMap { msg -> foo(msg, session.bufferFactory()) })
    }

    private fun foo(input: String, factory: DataBufferFactory): Mono<WebSocketMessage> {
        val buffer = factory.wrap(input.toByteArray())
        return Mono.just(WebSocketMessage(WebSocketMessage.Type.TEXT, buffer))
    }
}