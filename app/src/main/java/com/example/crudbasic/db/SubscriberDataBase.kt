package com.example.crudbasic.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// to present the actual database
@Database(entities = [Subscriber::class], version = 1)
abstract class SubscriberDataBase : RoomDatabase() {

    abstract val subscriberDAO: SubsciberDAO

    // we should only use one interface of room
    // database for entire app
    // to avoid unexpected errors

    // we create singleton as companion object
    companion object {
        // this reference to the SubscriberDataBase
        @Volatile
        // make field immediately made visible to other thread
        private var INSTANCE: SubscriberDataBase? = null


        fun getInstance(context: Context): SubscriberDataBase {
            // in this block we add synchronized block
            // lock to represent subscriberDataBase
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SubscriberDataBase::class.java,
                        "subscriber_data_db"
                    ).build()
                }
                return instance
            }
        }
    }

}