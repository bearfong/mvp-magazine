package taiwan.no1.app.data.mapper;

import android.support.annotation.NonNull;

import com.innahema.collections.query.queriables.Queryable;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import taiwan.no1.app.data.entities.CreditsInFilmEntity;
import taiwan.no1.app.domain.mapper.IBeanMapper;
import taiwan.no1.app.mvp.models.CreditsInFilmModel;
import taiwan.no1.app.mvp.models.CreditsInFilmModel.CastInFilmBean;
import taiwan.no1.app.mvp.models.CreditsInFilmModel.CrewInFilmBean;

/**
 * Base mapper class used to transform between {@link CreditsInFilmModel} (in the kotlin layer) and {@link CreditsInFilmEntity}
 * (in the data layer).
 *
 * @author Jieyi
 * @since 1/4/17
 */

@Singleton
public class CreditsInFilmMapper implements IBeanMapper<CreditsInFilmModel, CreditsInFilmEntity> {
    @Inject
    public CreditsInFilmMapper() {
    }

    /**
     * Implement {@inheritDoc}
     */
    @NonNull
    @Override
    @Deprecated
    public CreditsInFilmEntity transformFrom(@NonNull CreditsInFilmModel model) {
        throw new Error("No-op");
    }

    /**
     * Implement {@inheritDoc}
     */
    @NonNull
    @Override
    public CreditsInFilmModel transformTo(@NonNull CreditsInFilmEntity entity) {
        List<CastInFilmBean> castBeen = null != entity.getCast() ?
                Queryable.from(entity.getCast())
                         .map(data -> new CreditsInFilmModel.CastInFilmBean(data.isAdult(),
                                                                            data.getCharacter(),
                                                                            data.getCredit_id(),
                                                                            data.getId(),
                                                                            data.getOriginal_title(),
                                                                            data.getPoster_path(),
                                                                            data.getRelease_date(),
                                                                            data.getTitle(),
                                                                            data.getMedia_type(),
                                                                            data.getEpisode_count(),
                                                                            data.getFirst_air_date(),
                                                                            data.getName(),
                                                                            data.getOriginal_name()))
                         .toList() :
                Collections.emptyList();
        List<CrewInFilmBean> crewBeen = null != entity.getCrew() ?
                Queryable.from(entity.getCrew())
                         .map(data -> new CreditsInFilmModel.CrewInFilmBean(data.isAdult(),
                                                                            data.getCredit_id(),
                                                                            data.getDepartment(),
                                                                            data.getId(),
                                                                            data.getJob(),
                                                                            data.getOriginal_title(),
                                                                            data.getPoster_path(),
                                                                            data.getRelease_date(),
                                                                            data.getTitle(),
                                                                            data.getMedia_type()))
                         .toList() :
                Collections.emptyList();

        return new CreditsInFilmModel(castBeen, crewBeen);
    }
}
