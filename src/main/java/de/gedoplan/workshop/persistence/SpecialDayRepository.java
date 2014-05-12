package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.domain.SpecialDay;
import de.gedoplan.workshop.qualifier.All;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

@ApplicationScoped
//@Stateless
@Transactional(value = TxType.REQUIRED)
public class SpecialDayRepository
{
  //  @PersistenceContext(unitName = "default")
  @Inject
  @Default
  EntityManager entityManager;

  public void persist(SpecialDay entity)
  {
    this.entityManager.persist(entity);
  }

  public SpecialDay findById(String id)
  {
    return this.entityManager.find(SpecialDay.class, id);
  }

  public void merge(SpecialDay entity)
  {
    this.entityManager.merge(entity);
  }

  public void remove(SpecialDay entity)
  {
    this.entityManager.remove(entity);
  }

  @Produces
  @All
  public List<SpecialDay> findAll()
  {
    TypedQuery<SpecialDay> query = this.entityManager.createQuery("select object(sd) from SpecialDay sd ", SpecialDay.class);
    return query.getResultList();
  }
}