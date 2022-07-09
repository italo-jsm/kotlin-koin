import dependencyinjection.messageModule

import org.koin.core.context.startKoin
import service.QueueService

suspend fun main(){
    startKoin {
        printLogger()
        modules(messageModule())
    }

    val service: QueueService = QueueService()
    service.readMessages()
}