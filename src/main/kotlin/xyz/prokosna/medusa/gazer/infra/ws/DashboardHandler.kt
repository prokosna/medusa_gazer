package xyz.prokosna.medusa.gazer.infra.ws

import org.springframework.stereotype.Component
import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.WebSocketMessage
import org.springframework.web.reactive.socket.WebSocketSession
import reactor.core.publisher.EmitterProcessor
import reactor.core.publisher.Mono

@Component
class DashboardHandler : WebSocketHandler {

    private val ep: EmitterProcessor<String> = EmitterProcessor.create()

    override fun handle(session: WebSocketSession): Mono<Void> {
        session.receive()
                .map { webSocketMessage: WebSocketMessage -> webSocketMessage.payloadAsText }
                .subscribe()
        return session.send(Mono.just(session.textMessage("Connected!"))).then(session.send(ep.map(session::textMessage)))
    }
}