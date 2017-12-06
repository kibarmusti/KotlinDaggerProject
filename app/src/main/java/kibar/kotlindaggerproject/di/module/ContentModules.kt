package kibar.kotlindaggerproject.di.module

import dagger.Module
import dagger.Provides
import kibar.kotlindaggerproject.Favorite
import kibar.kotlindaggerproject.FavoriteDao
import kibar.kotlindaggerproject.di.misc.ContentScope
import kibar.kotlindaggerproject.room.RoomDatabase
import javax.inject.Inject

@ContentScope
@Module
class ContentModules {

    val database: RoomDatabase

    @Inject
    constructor(database: RoomDatabase) {
        this.database = database
    }

    @ContentScope
    @Provides
    fun provideFavoriteDao()
            = database.favoriteDao()

    @Provides
    fun provideFavorite(dao: FavoriteDao)
            = Favorite(dao)

}