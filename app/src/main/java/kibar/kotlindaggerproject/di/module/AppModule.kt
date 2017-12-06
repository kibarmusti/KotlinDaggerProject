package kibar.kotlindaggerproject.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import kibar.kotlindaggerproject.di.misc.AppScope
import kibar.kotlindaggerproject.di.misc.ApplicationContext

@AppScope
@Module
class AppModule(private val application: Application) {

    @AppScope
    @Provides
    fun provideApplication(): Application = application

    @AppScope
    @Provides
    @ApplicationContext
    fun provideContext(): Context = application.applicationContext

}