package taiwan.no1.app.mvp.presenters.adapter

import taiwan.no1.app.api.config.TMDBConfig
import taiwan.no1.app.mvp.contracts.adapter.TvSeasonAdapterContract.Presenter
import taiwan.no1.app.mvp.contracts.adapter.TvSeasonAdapterContract.View
import taiwan.no1.app.mvp.models.tv.TvSeasonsModel

/**
 *
 * @author  Jieyi
 * @since   3/3/17
 */

class TvSeasonAdapterPresenter: BaseAdapterPresenter<View, TvSeasonsModel>(), Presenter {
    override fun init(viewHolder: View, model: TvSeasonsModel) {
        super.init(viewHolder, model)

        this.viewHolder.also {
            it.showTvPoster(TMDBConfig.BASE_IMAGE_URL + this.model.poster_path)
            it.showTvEpisodeNumber(this.model.episode_count.toString())
            it.showTvSeasonNumber(this.model.season_number.toString())
            it.showTvAirDate(this.model.air_date.orEmpty())
        }
    }

    override fun onItemClicked(tag: Int) {
//        RxBus.get().post(RxbusTag.FRAGMENT_CHILD_NAVIGATOR, hashMapOf(
//                Pair(ViewPagerMainCtrlFragment.NAVIGATOR_ARG_FRAGMENT,
//                        TvDetailFragment.newInstance(model.id.toString(), tag)),
//                Pair(ViewPagerMainCtrlFragment.NAVIGATOR_ARG_TAG, tag)))
    }
} 