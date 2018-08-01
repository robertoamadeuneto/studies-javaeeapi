package br.com.studiesjavaeeapi.api.domain.service.impl;

import br.com.studiesjavaeeapi.api.domain.model.Profile;
import java.util.List;
import javax.inject.Inject;
import br.com.studiesjavaeeapi.api.domain.service.ProfileService;
import br.com.studiesjavaeeapi.api.infra.repository.ProfileRepository;
import br.com.studiesjavaeeapi.api.infra.repository.Repository;
import javax.transaction.Transactional;

/**
 * Class responsible to implement all service cases related to the
 * {@link Profile} entity.
 *
 * @author Roberto Amadeu Neto
 * @since 27/11/2017
 */
public class ProfileServiceImpl implements ProfileService {

    @Inject
    private ProfileRepository profileRepository;

    @Override
    public Repository<Profile, Integer> getRepository() {
        return profileRepository;
    }

    @Override
    public List<Profile> findAll() {
        return getRepository().findAll();
    }

    @Override
    public Profile findById(Integer id) {
        return getRepository().findById(id);
    }

    @Override
    @Transactional
    public void create(Profile profile) {
        getRepository().create(profile);
    }

    @Override
    @Transactional
    public void update(Profile profile) {
        getRepository().update(profile);
    }

    @Override
    @Transactional
    public void remove(Integer id) {
        getRepository().remove(getRepository().findById(id));
    }
}
