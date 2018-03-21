package xyz.prokosna.medusa.gazer.app.service

import org.springframework.stereotype.Service
import xyz.prokosna.medusa.gazer.domain.service.DomainEventPublisher
import java.time.OffsetDateTime

@Service
class FaceDetectedService(private val domainEventPublisher: DomainEventPublisher) {
    fun detect(type: String, timestamp: OffsetDateTime, thumbnail: String) {
        TODO("not implemented")
    }
}