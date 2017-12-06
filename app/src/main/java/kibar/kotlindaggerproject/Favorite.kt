package kibar.kotlindaggerproject

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import javax.inject.Inject

class Favorite @Inject constructor(val dao: FavoriteDao) {

    val count
        get() = dao.count()
    val all
        get() = dao.all

}

object FAVORITEDB_CONS{
    const val TABLE = "Favorites"
    const val ID    = "uid"
    const val DATE  = "date"
}

@Entity(tableName = FAVORITEDB_CONS.TABLE)
class FavoriteDataModel(
        @ColumnInfo(name = FAVORITEDB_CONS.ID) @PrimaryKey(autoGenerate = true) var uid: Int,
        @ColumnInfo(name = FAVORITEDB_CONS.DATE) var date: Long)

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM ${FAVORITEDB_CONS.TABLE} WHERE ${FAVORITEDB_CONS.ID} = :uid")
    fun get(uid: Int): LiveData<FavoriteDataModel>

    @get:Query("SELECT * FROM ${FAVORITEDB_CONS.TABLE}")
    val all: LiveData<MutableList<FavoriteDataModel>>

    @Query("SELECT COUNT(*) FROM ${FAVORITEDB_CONS.TABLE}")
    fun count(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(model: FavoriteDataModel): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg models: FavoriteDataModel): LongArray

    @Query("DELETE FROM ${FAVORITEDB_CONS.TABLE} WHERE ${FAVORITEDB_CONS.ID} = :uid")
    fun delete(uid: Int)

    @Query("DELETE FROM ${FAVORITEDB_CONS.TABLE}")
    fun clear()

}