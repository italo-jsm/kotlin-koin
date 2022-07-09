package messaging

import aws.sdk.kotlin.services.sqs.SqsClient
import aws.sdk.kotlin.services.sqs.model.ReceiveMessageRequest
import aws.sdk.kotlin.services.sqs.model.SendMessageRequest

class QueueConsumer {
    suspend fun receiveMessages(queueUrlVal: String?) {

        println("Retrieving messages from $queueUrlVal")

        val receiveMessageRequest = ReceiveMessageRequest {
            queueUrl = queueUrlVal
            maxNumberOfMessages =5
        }

        SqsClient { region = "us-east-1" }.use { sqsClient ->
            val response =  sqsClient.receiveMessage(receiveMessageRequest)
            response.messages?.forEach { message ->
                println(message.body)
            }
        }
    }

    suspend fun sendMessages(queueUrlVal: String, message : String) {
        println("Sending multiple messages")
        println("\nSend message")
        val sendRequest = SendMessageRequest {
            queueUrl = queueUrlVal
            messageBody = message
            delaySeconds = 10
        }

        SqsClient { region = "us-east-1" }.use { sqsClient ->
            sqsClient.sendMessage(sendRequest)
            println("A single message was successfully sent.")
        }
    }
}