package xyz.prokosna.medusa.gazer.infra.messaging

import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitAdmin
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import xyz.prokosna.medusa.gazer.domain.event.DomainEvent
import xyz.prokosna.medusa.gazer.domain.service.DomainEventPublisher

@Service
class DomainEventPublisherRabbit: DomainEventPublisher {


    override fun publish(event: DomainEvent) {
        val connectionFactory = CachingConnectionFactory()
        val admin = RabbitAdmin(connectionFactory)
        admin.declareQueue(Queue("mytest"))
        val template = RabbitTemplate(connectionFactory)
        template.convertAndSend("mytest", "foo")
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}