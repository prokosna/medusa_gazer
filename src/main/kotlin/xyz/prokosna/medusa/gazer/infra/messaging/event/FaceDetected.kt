package xyz.prokosna.medusa.gazer.infra.messaging.event

import java.time.OffsetDateTime

data class FaceDetected(val type: String,
                        val timestamp: OffsetDateTime,
                        val thumbnail: String)
