package ru.andrewgo.demo.application

import BarEventsHolder
import BarMenuHolder
import com.mongodb.ConnectionString
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val connectionString = System.getenv("MONGODB_URI")?.let {
    ConnectionString(it)
} ?: ConnectionString("mongodb://root:pass@127.0.0.1:27017")
val client = KMongo.createClient(connectionString).coroutine
val database = client.getDatabase(connectionString.database ?: "forte-piano")

val barEventsHolderCollection = database.getCollection<BarEventsHolder>()
val barMenuHolderCollection = database.getCollection<BarMenuHolder>()

suspend fun initDbWithMockData() {
    barEventsHolderCollection.insertMany(barEventsMock)
    barMenuHolderCollection.insertMany(barMenuMock)
}

