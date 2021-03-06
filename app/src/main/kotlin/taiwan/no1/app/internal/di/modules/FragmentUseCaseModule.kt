package taiwan.no1.app.internal.di.modules

import dagger.Module
import dagger.Provides
import taiwan.no1.app.domain.executor.PostExecutionThread
import taiwan.no1.app.domain.executor.ThreadExecutor
import taiwan.no1.app.domain.repository.IRepository
import taiwan.no1.app.domain.usecase.*
import taiwan.no1.app.internal.di.annotations.PerFragment

/**
 * Dagger use case module that provides user related collaborators.
 *
 * @author  Jieyi
 * @since   12/21/16
 */

@Module
class FragmentUseCaseModule {
    @Provides
    @PerFragment
    fun ProvideMovieDetail(threadExecutor: ThreadExecutor,
                           postExecutionThread: PostExecutionThread,
                           repository: IRepository): MovieDetail
            = MovieDetail(threadExecutor, postExecutionThread, repository)

    @Provides
    @PerFragment
    fun ProvideMovieLists(threadExecutor: ThreadExecutor,
                          postExecutionThread: PostExecutionThread,
                          repository: IRepository): MovieLists
            = MovieLists(threadExecutor, postExecutionThread, repository)

    @Provides
    @PerFragment
    fun ProvideCastDetail(threadExecutor: ThreadExecutor,
                          postExecutionThread: PostExecutionThread,
                          repository: IRepository): CastDetail
            = CastDetail(threadExecutor, postExecutionThread, repository)

    @Provides
    @PerFragment
    fun ProvideTvLists(threadExecutor: ThreadExecutor,
                       postExecutionThread: PostExecutionThread,
                       repository: IRepository): TvLists
            = TvLists(threadExecutor, postExecutionThread, repository)

    @Provides
    @PerFragment
    fun ProvideTvDetail(threadExecutor: ThreadExecutor,
                        postExecutionThread: PostExecutionThread,
                        repository: IRepository): TvDetail
            = TvDetail(threadExecutor, postExecutionThread, repository)

    @Provides
    @PerFragment
    fun ProvideTvSeasonDetail(threadExecutor: ThreadExecutor,
                              postExecutionThread: PostExecutionThread,
                              repository: IRepository): TvSeasonDetail
            = TvSeasonDetail(threadExecutor, postExecutionThread, repository)

    @Provides
    @PerFragment
    fun ProvideTvEpisodeDetail(threadExecutor: ThreadExecutor,
                               postExecutionThread: PostExecutionThread,
                               repository: IRepository): TvEpisodeDetail
            = TvEpisodeDetail(threadExecutor, postExecutionThread, repository)

    @Provides
    @PerFragment
    fun ProvideCastLists(threadExecutor: ThreadExecutor,
                         postExecutionThread: PostExecutionThread,
                         repository: IRepository): CastLists
            = CastLists(threadExecutor, postExecutionThread, repository)
}