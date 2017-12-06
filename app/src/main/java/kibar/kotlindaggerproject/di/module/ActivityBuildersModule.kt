package kibar.kotlindaggerproject.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kibar.kotlindaggerproject.FavoriteFragmentModule
import kibar.kotlindaggerproject.MainActivity
import kibar.kotlindaggerproject.di.misc.ActivityScope

@ActivityScope
@Module(includes = [MainActivityModule::class])
class ActivityModules

@ActivityScope
@Module(includes = [FragmentViewModelModule::class])
abstract class MainActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [FavoriteFragmentModule::class])
    abstract fun bind(): MainActivity

}