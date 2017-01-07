package taiwan.no1.app.mvp.contracts

import taiwan.no1.app.mvp.models.MovieDetailModel
import taiwan.no1.app.mvp.presenters.IPresenter
import taiwan.no1.app.mvp.views.IFragmentView
import taiwan.no1.app.mvp.views.IView

/**
 * This specifies the contract between the [IPresenter] and the [IView].
 *
 * @author  Jieyi
 * @since   12/29/16
 */

interface MovieDetailContract {
    interface Presenter: IPresenter<View> {
        fun requestMovieDetail(movieId: Int)
    }

    interface View: IView, IFragmentView {
        fun showMovieDetail(movieDetailModel: MovieDetailModel)
    }
}