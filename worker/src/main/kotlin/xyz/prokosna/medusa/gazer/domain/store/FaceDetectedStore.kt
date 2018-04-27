package xyz.prokosna.medusa.gazer.domain.store

import org.springframework.stereotype.Repository
import xyz.prokosna.medusa.gazer.domain.event.FaceDetected

@Repository
interface FaceDetectedStore {
    fun append(event: FaceDetected)
    fun findAll(): List<FaceDetected>
}