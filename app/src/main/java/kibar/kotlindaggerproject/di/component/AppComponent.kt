package kibar.kotlindaggerproject.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import kibar.kotlindaggerproject.App
import kibar.kotlindaggerproject.di.misc.AppScope
import kibar.kotlindaggerproject.di.module.AppModule
import kibar.kotlindaggerproject.di.module.DatabaseModule
import kibar.kotlindaggerproject.room.RoomDatabase

@AppScope
@Component(modules = [AndroidInjectionModule::class, AppModule::class, DatabaseModule::class])
interface AppComponent {

    interface Builder {
        @BindsInstance
        fun application(app: App): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
    fun getDatabase(): RoomDatabase

}