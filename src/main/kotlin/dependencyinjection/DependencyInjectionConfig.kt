package dependencyinjection

import messaging.QueueConsumer
import org.koin.dsl.module

fun messageModule() = module{
    single { QueueConsumer() }
}
