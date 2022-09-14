package com.example.crudbasic.repository

import com.example.crudbasic.db.SubsciberDAO
import com.example.crudbasic.db.Subscriber

class SubscriberRepository(private val dao: SubsciberDAO) {

    val subscribers = dao.getAllSubscriber()

    suspend fun insert(subscriber: Subscriber){
        dao.insertSubscriber(subscriber)
    }

    suspend fun update (subscriber: Subscriber){
        dao.updateSubscriber(subscriber)
    }

    suspend fun delete (subscriber: Subscriber){
        dao.deleteSubscriber(subscriber)
    }

    suspend fun deleteAll(){
        dao.deleteAll()
    }
}