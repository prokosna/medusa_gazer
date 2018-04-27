package xyz.prokosna.medusa.gazer.domain.event

import java.time.OffsetDateTime

data class FaceDetected(
        override val id: String,
        override val timestamp: OffsetDateTime,
        val thumbnail: String,
        val type: String = "face_detected") : DomainEvent
