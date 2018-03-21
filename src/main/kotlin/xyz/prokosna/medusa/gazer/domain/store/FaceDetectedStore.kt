package xyz.prokosna.medusa.gazer.domain.store

import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Repository
import xyz.prokosna.medusa.gazer.domain.event.FaceDetected

@Mapper
@Repository
interface FaceDetectedStore {
    fun append(event: FaceDetected)
    fun findAll(): List<FaceDetected>
}