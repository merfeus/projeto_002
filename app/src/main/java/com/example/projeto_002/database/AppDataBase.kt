package com.example.projeto_002.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.projeto_002.database.dao.GitDAO
import com.example.projeto_002.model.GitHubRepo
import com.example.projeto_002.model.Owner

@Database(
    entities = [GitHubRepo::class, Owner::class], version = 1
)
abstract class AppDataBase : RoomDatabase() {


    //funcao declarada para o Room implementar automaticamente nosso DAO
    abstract fun gitDAO(): GitDAO

    companion object {

    //Singleton que irá gerar nossa classe AppDatabse com tudo implementado pelo Room.
        fun getDataBase(context: Context): AppDataBase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                "git_app_db"
            )
                .allowMainThreadQueries()
                .build()
        }
    }

}