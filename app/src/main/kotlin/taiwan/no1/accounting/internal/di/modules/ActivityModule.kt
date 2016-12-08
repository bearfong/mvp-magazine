package taiwan.no1.accounting.internal.di.modules

import android.app.Activity
import dagger.Module
import dagger.Provides
import taiwan.no1.accounting.internal.di.annotations.PerActivity

/**
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 * 
 * @author  Jieyi Wu
 * @version 0.0.1
 * @since   5/29/16
 */
@Module
class ActivityModule(var activity: Activity) {
    @Provides
    @PerActivity
    fun activity(): Activity = this.activity
}