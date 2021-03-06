package taiwan.no1.app.ui

import android.content.Context
import android.content.Intent


/**
 * Class used to navigate between activities through the application.
 *
 * @author  Jieyi
 * @since   12/6/16
 */

class Navigator {
    companion object {
        var ACTIVITY_RESOURCE_ID: String = "activity_id"
    }

    /**
     * Goes to the user list screen.
     *
     * @param context A Context needed to open the destiny activity.
     */
    fun navigateToVideoActivity(context: Context, intent: Intent) {
        context.startActivity(intent)
    }
}
