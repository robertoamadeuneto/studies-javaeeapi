package br.com.studiesjavaeeapi.api.infra.producer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Class responsible to provide a JPA Entity Manager.
 *
 * @author Roberto Amadeu Neto
 * @since 28/11/2017
 */
public class EntityManagerProducer {

    private static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("studies-javaeeapiPU");
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void close() {
        entityManagerFactory.close();
    }
}
