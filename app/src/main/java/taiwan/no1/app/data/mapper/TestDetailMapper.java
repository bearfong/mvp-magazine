package taiwan.no1.app.data.mapper;

import android.support.annotation.NonNull;

import com.innahema.collections.query.queriables.Queryable;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import taiwan.no1.app.data.entities.TestDetailEntity;
import taiwan.no1.app.domain.mapper.IBeanMapper;
import taiwan.no1.app.mvp.models.FilmImagesModel;
import taiwan.no1.app.mvp.models.FilmVideoModel;
import taiwan.no1.app.mvp.models.MovieDetailModel;
import taiwan.no1.app.mvp.models.MovieListResModel;
import taiwan.no1.app.mvp.models.TvDetailModel;

/**
 * Mapper class used to transform between {@link TvDetailModel} (in the kotlin layer) and {@link TestDetailEntity}
 * (in the data layer).
 * <p>
 * Created by weian on 2017/1/12.
 */

@Singleton
public class TestDetailMapper implements IBeanMapper<TvDetailModel, TestDetailEntity> {
    @Inject MovieVideosMapper tvVideosMapper;
    @Inject MovieImagesMapper tvImagesMapper;
    @Inject MovieListResMapper tvListResMapper;
    @Inject CreditsMapper creditsMapper;

    @Inject
    public TestDetailMapper() {
    }

    /**
     * Implement {@inheritDoc}
     */
    @NonNull
    @Override
    @Deprecated
    public TestDetailEntity transformFrom(@NonNull TvDetailModel model) {
        return null;
    }

    /**
     * Implement {@inheritDoc}
     */
    @NonNull
    @Override
    public TvDetailModel transformTo(@NonNull TestDetailEntity entity) {
        List<FilmVideoModel> movieVideosModels = Queryable.from(entity.getVideos().getResults())
                                                          .map(tvVideosMapper::transformTo)
                                                          .toList();

        FilmImagesModel tvImagesModel = this.tvImagesMapper.transformTo(entity.getImages());

        MovieListResModel tvListResModel = this.tvListResMapper.transformTo(entity.getSimilar());

        //        CreditsModel creditsModel = this.creditsMapper.transformTo(entity.getCredits());

        List<TvDetailModel.CreatedByBean> tvCreatedByBean = Queryable.from(entity.getCreated_by())
                                                                     .map(data -> new TvDetailModel.CreatedByBean())
                                                                     .toList();
        List<TvDetailModel.GenresBean> genresBeen = Queryable.from(entity.getGenres())
                                                             .map(data -> new TvDetailModel.GenresBean(data.getId(),
                                                                                                       data.getName()))
                                                             .toList();

        List<TvDetailModel.NetworksBean> networksBeen = Queryable.from(entity.getNetworks())
                                                                 .map(data -> new TvDetailModel.NetworksBean(data.getId(),
                                                                                                             data.getName()))
                                                                 .toList();

        List<TvDetailModel.ProductionCompaniesBean> productionCompaniesBeen = Queryable.from(entity.getProduction_companies())
                                                                                       .map(data -> new TvDetailModel.ProductionCompaniesBean(
                                                                                               data.getName(),
                                                                                               data.getId()))
                                                                                       .toList();

        List<TvDetailModel.SeasonsBean> seasonsBeen = Queryable.from(entity.getSeasons())
                                                               .map(data -> new TvDetailModel.SeasonsBean(data.getAir_date(),
                                                                                                          data.getEpisode_count(),
                                                                                                          data.getId(),
                                                                                                          data.getPoster_path(),
                                                                                                          data.getSeason_number()))
                                                               .toList();

        return new TvDetailModel(entity.getBackdrop_path(),
                                 entity.getFirst_air_date(),
                                 entity.getHomepage(),
                                 entity.getId(),
                                 entity.isIn_production(),
                                 entity.getLast_air_date(),
                                 entity.getName(),
                                 entity.getNumber_of_episodes(),
                                 entity.getNumber_of_seasons(),
                                 entity.getOriginal_language(),
                                 entity.getOriginal_name(),
                                 entity.getOverview(),
                                 entity.getPopularity(),
                                 entity.getPoster_path(),
                                 entity.getStatus(),
                                 entity.getType(),
                                 entity.getVote_average(),
                                 entity.getVote_count(),
                                 new MovieDetailModel.VideosBean(movieVideosModels),
                                 tvImagesModel,
                                 tvListResModel,
                                 tvCreatedByBean,
                                 entity.getEpisode_run_time(),
                                 genresBeen,
                                 entity.getLanguages(),
                                 networksBeen,
                                 entity.getOrigin_country(),
                                 productionCompaniesBeen,
                                 seasonsBeen);
    }
}