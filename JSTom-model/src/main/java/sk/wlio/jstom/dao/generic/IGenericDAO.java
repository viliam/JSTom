package sk.wlio.jstom.dao.generic;

public interface IGenericDAO<T, ID> {

    T find( ID id);
    void persist(T t);
}
