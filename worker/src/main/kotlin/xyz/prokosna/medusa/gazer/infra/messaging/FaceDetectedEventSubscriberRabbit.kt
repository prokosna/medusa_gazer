package xyz.prokosna.medusa.gazer.infra.messaging

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.FluxSink
import xyz.prokosna.medusa.gazer.domain.event.FaceDetected
import xyz.prokosna.medusa.gazer.domain.service.FaceDetectedEventSubscriber
import java.time.Duration
import java.time.OffsetDateTime
import java.time.temporal.ChronoUnit

@Service
class FaceDetectedEventSubscriberRabbit : FaceDetectedEventSubscriber {
    override fun emit(): Flux<FaceDetected> {
        return Flux.create<FaceDetected>({ emitter ->
            emitter.next(FaceDetected("a", OffsetDateTime.now(), "foo"))
            emitter.next(FaceDetected("b", OffsetDateTime.now(), "bar"))
            emitter.next(FaceDetected("c", OffsetDateTime.now(), "hoge"))
        }, FluxSink.OverflowStrategy.BUFFER)
                .timeout(Duration.of(5L, ChronoUnit.SECONDS))
    }
}
