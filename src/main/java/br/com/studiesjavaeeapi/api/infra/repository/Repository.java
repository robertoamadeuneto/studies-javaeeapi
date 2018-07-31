package br.com.studiesjavaeeapi.api.infra.repository;

import java.util.List;
import javax.persistence.EntityManager;

/**
 * Interface responsible to define all repository cases of an entity.
 *
 * @param <T> Entity class.
 * @param <ID> Entity identifier.
 * @author Roberto Amadeu Neto
 * @since 27/11/2017
 */
public interface Repository<T, ID> {

    /**
     * Returns the entity repository.
     *
     * @return an instance of the entity repository.
     */
    EntityManager getEntityManager();

    /**
     * Finds all entities on database.
     *
     * @return a {@link List} of entities.
     */
    List<T> findAll();

    /**
     * Finds an entity on database by a given identifier.
     *
     * @param id Entity identifier.
     * @return an entity instance.
     */
    T findById(ID id);

    /**
     * Creates a new entity on database.
     *
     * @param entity An entity instance.
     */
    void create(T entity);

    /**
     * Updates an existent entity on database.
     *
     * @param entity An entity instance.
     */
    void update(T entity);

    /**
     * Removes an existent entity from database by a given identifier.
     *
     * @param id Entity identifier.
     */
    void remove(T entity);
}
