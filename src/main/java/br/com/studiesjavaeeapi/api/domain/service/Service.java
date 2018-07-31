package br.com.studiesjavaeeapi.api.domain.service;

import br.com.studiesjavaeeapi.api.infra.repository.Repository;
import java.util.List;

/**
 * Interface responsible to define all service cases of an entity.
 *
 * @param <T> Entity class.
 * @param <ID> Entity identifier.
 * @author Roberto Amadeu Neto
 * @since 27/11/2017
 */
public interface Service<T, ID> {

    /**
     * Returns the entity repository.
     *
     * @return an instance of the entity repository.
     */
    Repository<T, ID> getRepository();

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
    void remove(ID id);
}
