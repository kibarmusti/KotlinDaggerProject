package kibar.kotlindaggerproject.di.component

import dagger.Subcomponent
import kibar.kotlindaggerproject.di.module.ActivityModules

//I can't add here this scope @ActivityScope -> Error:(4, 1) error: @kibar.kotlindaggerproject.di.misc.ContentScope kibar.kotlindaggerproject.di.component.ContentComponent depends on more than one scoped component:
@Subcomponent(modules = [ActivityModules::class])
interface ActivityComponent