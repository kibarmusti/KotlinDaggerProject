package kibar.kotlindaggerproject.di.module

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import kibar.kotlindaggerproject.di.misc.AppScope
import kibar.kotlindaggerproject.di.misc.ApplicationContext
import kibar.kotlindaggerproject.room.RoomDatabase

@AppScope
@Module
class DatabaseModule {

    @AppScope
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): RoomDatabase =
            Room.databaseBuilder(context, RoomDatabase::class.java, RoomDatabase.CONS.NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()

}