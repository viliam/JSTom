package sk.wlio.jstom.dao.generic;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Transactional
public abstract class AbstractGenericDAO<T, ID> implements IGenericDAO<T, ID> {

    protected abstract EntityManager getEM();
    protected abstract Class<T> getEntityClass();

    @Override
    public T find(ID id) {
        return getEM().find( getEntityClass(), id);
    }

    @Override
    public void persist(T t) {
        getEM().persist(t);
    }
}
