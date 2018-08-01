package br.com.studiesjavaeeapi.api.infra.repository.impl;

import br.com.studiesjavaeeapi.api.infra.repository.Repository;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * Abstract JPA repository with all persistence operations.
 *
 * @param <T> Entity class.
 * @param <ID> Entity identifier.
 * @author Roberto Amadeu Neto
 * @since 27/11/2017
 */
public abstract class AbstractRepositoryImpl<T, ID> implements Repository<T, ID> {

    private final EntityManager entityManager;

    public AbstractRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    private Class<T> getTypeClass() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public List<T> findAll() {
        try {
            return getEntityManager().createQuery("from " + getTypeClass().getName()).getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public T findById(ID id) {
        try {
            return getEntityManager().find(getTypeClass(), id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void create(T obj) {
        try {
            getEntityManager().persist(obj);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(T obj) {
        try {
            getEntityManager().merge(obj);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void remove(T obj) {
        try {
            getEntityManager().remove(obj);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
