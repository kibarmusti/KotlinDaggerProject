package kibar.kotlindaggerproject.di.component

import dagger.Component
import dagger.android.AndroidInjectionModule
import kibar.kotlindaggerproject.Favorite
import kibar.kotlindaggerproject.di.misc.ContentScope
import kibar.kotlindaggerproject.di.module.ContentModules

@ContentScope
@Component(
        dependencies = [AppComponent::class, ActivityComponent::class],
        modules = [AndroidInjectionModule::class, ContentModules::class])
interface ContentComponent {

    fun inject(favorite: Favorite)
    fun getFavorite(): Favorite

}