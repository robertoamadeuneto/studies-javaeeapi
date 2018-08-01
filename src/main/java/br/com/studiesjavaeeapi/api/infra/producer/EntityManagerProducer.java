package br.com.studiesjavaeeapi.api.infra.producer;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 * Class responsible to provide a JPA Entity Manager.
 *
 * @author Roberto Amadeu Neto
 * @since 28/11/2017
 */
public class EntityManagerProducer {
    
    @Produces
    @PersistenceUnit(unitName = "studies-javaeeapiPU")
    private EntityManagerFactory entityManagerFactory;
    
    @Produces
    @PersistenceContext(unitName = "studies-javaeeapiPU")
    private EntityManager entityManager;  
}
