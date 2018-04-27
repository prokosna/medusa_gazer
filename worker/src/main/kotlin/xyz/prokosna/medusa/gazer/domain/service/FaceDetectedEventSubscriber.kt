package xyz.prokosna.medusa.gazer.domain.service

import reactor.core.publisher.Flux
import xyz.prokosna.medusa.gazer.domain.event.FaceDetected

interface FaceDetectedEventSubscriber {
    fun emit(): Flux<FaceDetected>
}