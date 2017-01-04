package taiwan.no1.app.mvp.contracts

import taiwan.no1.app.mvp.models.CastDetailModel
import taiwan.no1.app.mvp.presenters.IPresenter
import taiwan.no1.app.mvp.views.IFragmentView
import taiwan.no1.app.mvp.views.IView

/**
 * This specifies the contract between the [IPresenter] and the [IView].
 *
 * @author  Jieyi
 * @version 0.0.1
 * @since   1/1/17
 */

interface CastDetailContract {
    interface Presenter: IPresenter<View> {
        fun requestCastDetail(castId: Int)
    }

    interface View: IView, IFragmentView {
        fun showCastDetail(castDetailModel: CastDetailModel)
    }
}