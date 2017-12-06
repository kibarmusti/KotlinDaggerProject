package kibar.kotlindaggerproject

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import kibar.kotlindaggerproject.di.component.AppComponent
import kibar.kotlindaggerproject.di.component.ContentComponent
import kibar.kotlindaggerproject.di.component.DaggerAppComponent
import kibar.kotlindaggerproject.di.component.DaggerContentComponent
import kibar.kotlindaggerproject.di.module.AppModule

import javax.inject.Inject

class App : Application(), HasActivityInjector {

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var instance: App? = null

        fun getAppComponent(): AppComponent?
                = instance?.appComponent

        fun getContentComponent(): ContentComponent?
                = instance?.contentComponent
    }

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Activity>
    private var appComponent: AppComponent? = null
        get() {
            if (field == null) field = createAppComponent()

            return field
        }

    private fun createAppComponent(): AppComponent? =
            DaggerAppComponent.builder()
                    .appModule(AppModule(this))
                    .build()
                    .also { it.inject(this@App); appComponent = it }


    private var contentComponent: ContentComponent? = null
        get() {
            if (field == null) field = createContentComponent()

            return field
        }

    private fun createContentComponent(): ContentComponent? =
            DaggerContentComponent.builder()
                    .appComponent(appComponent)
                    .build()
                    .also { contentComponent = it }

    override fun onCreate() {
        super.onCreate()
        createAppComponent()
        AppInjector.init(let { instance = this; this })
    }

    override fun activityInjector() = injector

}