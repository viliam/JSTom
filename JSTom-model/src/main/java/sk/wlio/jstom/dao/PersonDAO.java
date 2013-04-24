package sk.wlio.jstom.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sk.wlio.jstom.dao.generic.AbstractGenericDAO;
import sk.wlio.jstom.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class PersonDAO extends AbstractGenericDAO<Person, Long> {

    @PersistenceContext
    private EntityManager em; //<co id="co_injectEM"/>

    @Override
    protected EntityManager getEM() {
        return em;
    }

    @Override
    protected Class<Person> getEntityClass() {
        return Person.class;
    }
}
