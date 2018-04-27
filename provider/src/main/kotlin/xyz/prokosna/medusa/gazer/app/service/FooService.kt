package xyz.prokosna.medusa.gazer.app.service

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.FluxSink
import java.time.Duration

@Service
class FooService {
    fun emit(): Flux<String> {
        return Flux.create<String>({ emitter ->
            emitter.next("Kanon")
            emitter.next("Ako")
            emitter.next("Rinko")
        }, FluxSink.OverflowStrategy.BUFFER)
                .delaySubscription(Duration.ofSeconds(5L))
    }
}