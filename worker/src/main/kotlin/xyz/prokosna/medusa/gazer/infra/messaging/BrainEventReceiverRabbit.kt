package xyz.prokosna.medusa.gazer.infra.messaging

import org.springframework.stereotype.Component
import xyz.prokosna.medusa.gazer.app.service.FaceDetectedService
import java.util.concurrent.CountDownLatch

@Component
class BrainEventReceiverRabbit(private val faceDetectedService: FaceDetectedService){

    private val latch = CountDownLatch(1)

    fun receiveMessage(message: String) {
        println(message)
        latch.countDown()
    }

    fun getLatch(): CountDownLatch = latch
}