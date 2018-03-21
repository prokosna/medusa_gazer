package xyz.prokosna.medusa.gazer.domain.service

import xyz.prokosna.medusa.gazer.domain.event.DomainEvent

interface DomainEventPublisher {
    fun publish(event: DomainEvent)
}