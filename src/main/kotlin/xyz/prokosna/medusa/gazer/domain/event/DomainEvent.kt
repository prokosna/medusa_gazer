package xyz.prokosna.medusa.gazer.domain.event

import java.time.OffsetDateTime

interface DomainEvent {
    val id: String
    val timestamp: OffsetDateTime
}