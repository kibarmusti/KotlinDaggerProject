package kibar.kotlindaggerproject.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kibar.kotlindaggerproject.FavoriteFragmentViewModel
import kibar.kotlindaggerproject.di.misc.FragmentScope
import kibar.kotlindaggerproject.di.viewmodel.ViewModelFactory
import kibar.kotlindaggerproject.di.viewmodel.ViewModelKey

@FragmentScope
@Module
abstract class FragmentViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteFragmentViewModel::class)
    abstract fun bindFavoriteViewModel(model: FavoriteFragmentViewModel): ViewModel

    @Binds
    abstract fun bindAppViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}