package kibar.kotlindaggerproject

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import kibar.kotlindaggerproject.di.misc.FragmentScope
import kibar.kotlindaggerproject.di.misc.Injectable
import kibar.kotlindaggerproject.di.viewmodel.ViewModelFactory
import timber.log.Timber
import javax.inject.Inject

class FavoriteFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    val viewmodel by lazy { ViewModelProviders.of(this, viewModelFactory).get(FavoriteFragmentViewModel::class.java) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favorite, container)
    }

    override fun onStart() {
        super.onStart()
        Timber.d("onstart")
    }

}

@FragmentScope
@Module
abstract class FavoriteFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindFragment(): FavoriteFragment

    @FragmentScope
    @Binds
    abstract fun bindActivity(mainActivity: MainActivity): Context

}

class FavoriteFragmentViewModel: ViewModel()