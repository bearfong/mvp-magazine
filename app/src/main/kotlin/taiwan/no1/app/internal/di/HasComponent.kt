package taiwan.no1.app.internal.di

/**
 * Interface representing a contract for clients that contains a component for dependency injection.
 *
 * @author  Jieyi
 * @since   2016/12/06
 */

interface HasComponent<out C> {
    fun getFragmentComponent(obj: Any?): C
}