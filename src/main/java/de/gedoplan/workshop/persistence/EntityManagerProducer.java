package de.gedoplan.workshop.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class EntityManagerProducer
{
  @PersistenceContext(unitName = "default")
  EntityManager entityManager;

  @Produces
  @Default
  public EntityManager getEntityManager()
  {
    return this.entityManager;
  }

}