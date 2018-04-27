package xyz.prokosna.medusa.gazer.infra.rest

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

data class Item(val foo: String)

@Component
class HelloHandler {
    fun getHello(req: ServerRequest): Mono<ServerResponse> = ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .body(Flux.just(Item(foo = "bar")), Item::class.java)
}