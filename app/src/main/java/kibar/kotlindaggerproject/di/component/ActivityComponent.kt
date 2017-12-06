package kibar.kotlindaggerproject.di.component

import dagger.Subcomponent
import kibar.kotlindaggerproject.di.module.ActivityModules

@Subcomponent(modules = [ActivityModules::class])
interface ActivityComponent