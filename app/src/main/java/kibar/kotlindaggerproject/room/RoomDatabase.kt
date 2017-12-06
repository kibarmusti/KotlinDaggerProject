package kibar.kotlindaggerproject.room

import android.arch.persistence.room.Database
import kibar.kotlindaggerproject.FavoriteDao
import kibar.kotlindaggerproject.FavoriteDataModel

@Database(
        version  = RoomDatabase.CONS.VERSION,
        entities = [FavoriteDataModel::class])
abstract class RoomDatabase : android.arch.persistence.room.RoomDatabase() {

    object CONS {
        const val VERSION   = 1
        const val NAME      = "app.db"
    }

    abstract fun favoriteDao(): FavoriteDao

}