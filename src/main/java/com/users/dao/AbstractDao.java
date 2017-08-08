package com.users.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.*;

public abstract class AbstractDao<T extends Serializable> {

    @Autowired
    protected SessionFactory sessionFactory;

    private Class<T> type;

    public AbstractDao() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * Get all records.
     *
     * @return the list of records.
     */
    public List<T> findAll() {
        return (List<T>) getSession().createCriteria(type).list();
    }


    /**
     * Get all records matching the specified list of Ids.
     *
     * @param ids the Ids to search for.
     * @return the list of records.
     */
    public List<T> findByIds(Set<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return new ArrayList<>(0);
        }
        return getSession().createCriteria(type).add(Restrictions.in("id", ids)).list();
    }


    /**
     * Get all records matching the specified list of codes.
     *
     * @param codes the codes to search for.
     * @return the list of records.
     */
    public List<T> findByCodes(Collection<String> codes) {
        if (codes == null || codes.isEmpty()) {
            return new ArrayList<>(0);
        }
        return getSession().createCriteria(type)
                .add(Restrictions.in("code", codes))
                .list();
    }

    /**
     * Get a single record by ID.
     *
     * @param id the ID to search for.
     * @return an {@link Optional} wrapping the search result.
     */
    public Optional<T> findOne(String id) {
        return Optional.ofNullable((T) getSession().get(type, id));
    }

    /**
     * Persist an entity.
     *
     * @param entity the entity to be persisted.
     * @return the persisted entity.
     */
    public T save(T entity) {
        getSession().saveOrUpdate(entity);
        return entity;
    }

    /**
     * Persist a collection of entities.
     *
     * @param entities the collection of entities to be persisted.
     */
    public void save(Collection<T> entities) {
        final Session session = getSession();
        entities.forEach(session::saveOrUpdate);
    }


    /**
     * Delete an entity.
     *
     * @param entity the entity to be deleted.
     */
    public void delete(T entity) {
        getSession().delete(entity);
    }

    /**
     * Delete c collection of entities.
     *
     * @param entities the entities to be deleted.
     */
    public void delete(Collection<T> entities) {
        entities.forEach(this::delete);
        getSession().flush();
    }
}
