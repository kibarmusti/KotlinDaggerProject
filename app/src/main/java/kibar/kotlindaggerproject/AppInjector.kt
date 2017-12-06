package kibar.kotlindaggerproject

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import kibar.kotlindaggerproject.di.misc.Injectable

object AppInjector {

    fun init(app: App) =
            app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
                fun handleActivity(activity: Activity) {
                    if (activity is FragmentActivity) {
                        activity.supportFragmentManager.registerFragmentLifecycleCallbacks(object : FragmentManager.FragmentLifecycleCallbacks() {
                            override fun onFragmentAttached(fm: FragmentManager?, fragment: Fragment?, context: Context?) {
                                if (fragment is Injectable) {
                                    AndroidSupportInjection.inject(fragment)
                                }
                            }
                        }, true)
                    }

                    if (activity is Injectable) AndroidInjection.inject(activity)
                }

                override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                    handleActivity(activity)
                }

                override fun onActivityStarted(activity: Activity) {}
                override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
                override fun onActivityStopped(activity: Activity) {}
                override fun onActivityResumed(activity: Activity) {}
                override fun onActivityPaused(activity: Activity) {}
                override fun onActivityDestroyed(activity: Activity) {}
            })

}