package br.com.studiesjavaeeapi.api.domain.service.impl;

import br.com.studiesjavaeeapi.api.domain.model.Profile;
import java.util.List;
import javax.inject.Inject;
import br.com.studiesjavaeeapi.api.domain.service.ProfileService;
import br.com.studiesjavaeeapi.api.infra.repository.ProfileRepository;
import br.com.studiesjavaeeapi.api.infra.repository.Repository;

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
        getRepository().getEntityManager().getTransaction().begin();
        List<Profile> profiles = getRepository().findAll();
        getRepository().getEntityManager().getTransaction().commit();
        getRepository().getEntityManager().close();
        return profiles;
    }

    @Override
    public Profile findById(Integer id) {
        getRepository().getEntityManager().getTransaction().begin();
        Profile profile = getRepository().findById(id);
        getRepository().getEntityManager().getTransaction().commit();
        getRepository().getEntityManager().close();
        return profile;
    }

    @Override
    public void create(Profile profile) {
        getRepository().getEntityManager().getTransaction().begin();
        getRepository().create(profile);
        getRepository().getEntityManager().getTransaction().commit();
        getRepository().getEntityManager().close();
    }

    @Override
    public void update(Profile profile) {
        getRepository().getEntityManager().getTransaction().begin();
        getRepository().update(profile);
        getRepository().getEntityManager().getTransaction().commit();
        getRepository().getEntityManager().close();
    }

    @Override
    public void remove(Integer id) {
        getRepository().getEntityManager().getTransaction().begin();
        getRepository().remove(getRepository().findById(id));
        getRepository().getEntityManager().getTransaction().commit();
        getRepository().getEntityManager().close();
    }
}
