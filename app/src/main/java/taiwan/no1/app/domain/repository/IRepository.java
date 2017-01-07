package taiwan.no1.app.domain.repository;

import android.support.annotation.NonNull;

import java.util.List;

import rx.Observable;
import taiwan.no1.app.data.repositiry.DataRepository;
import taiwan.no1.app.mvp.models.CastDetailModel;
import taiwan.no1.app.mvp.models.MovieBriefModel;
import taiwan.no1.app.mvp.models.MovieDetailModel;

/**
 * Interface that represents a Repository for getting a movie related data.
 *
 * @author Jieyi
 
 * @since 5/29/16
 */

public interface IRepository {
    /**
     * Get an {@link Observable} which will emit a {@link List<MovieBriefModel>}.
     *
     * @param page a page of popular videoLists.
     * @return {@link Observable}
     */
    @NonNull
    Observable<List<MovieBriefModel>> movies(final DataRepository.Movies category, final int page);

    /**
     * Get an {@link Observable} which will emit a {@link MovieDetailModel}.
     *
     * @param id a movie id.
     * @return {@link Observable}
     */
    @NonNull
    Observable<MovieDetailModel> detailMovie(final int id);

    /**
     * Get an {@link Observable} which will emit a {@link CastDetailModel}.
     *
     * @param id a cast id.
     * @return {@link Observable}
     */
    @NonNull
    Observable<CastDetailModel> castDetail(final int id);
}
