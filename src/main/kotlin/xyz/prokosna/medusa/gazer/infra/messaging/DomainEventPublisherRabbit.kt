package xyz.prokosna.medusa.gazer.infra.messaging

import org.springframework.stereotype.Service
import xyz.prokosna.medusa.gazer.domain.event.DomainEvent
import xyz.prokosna.medusa.gazer.domain.service.DomainEventPublisher

@Service
class DomainEventPublisherRabbit: DomainEventPublisher {
    override fun publish(event: DomainEvent) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}