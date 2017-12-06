package kibar.kotlindaggerproject

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kibar.kotlindaggerproject.room.RoomDatabase
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Fragment>
    override fun supportFragmentInjector() = androidInjector

    @Inject
    lateinit var database: RoomDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.showFragment).setOnClickListener({
            supportFragmentManager.beginTransaction()
                    .add(R.id.fragmentContainer, FavoriteFragment())
                    .disallowAddToBackStack()
                    .commitAllowingStateLoss()
        })
    }

}
