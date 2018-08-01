package br.com.studiesjavaeeapi.api.infra.repository.impl;

import br.com.studiesjavaeeapi.api.domain.model.Profile;
import br.com.studiesjavaeeapi.api.infra.repository.ProfileRepository;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Class responsible to implement all repository cases related to the
 * {@link Profile} entity.
 *
 * @author Roberto Amadeu Neto
 * @since 27/11/2017
 */
public class ProfileRepositoryImpl extends AbstractRepositoryImpl<Profile, Integer> implements ProfileRepository {

    @Inject
    public ProfileRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
