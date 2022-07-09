package service

import messaging.QueueConsumer
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class QueueService : KoinComponent {
    private val consumer by inject<QueueConsumer>()

    suspend fun readMessages(){
        consumer.receiveMessages("https://sqs.us-east-1.amazonaws.com/150976179326/testqueue")
    }
}