package dance.builder.persistence;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Class to manipulate data in the database
 * @param <T> Type
 * @author oponomarova
 */
public class GenericDAO<T> {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private final Class<T> type;
    private Class<T> entity;


    public GenericDAO(Class<T> type) {

        this.type = type;

    }


    /**
     * Get entity based on the id value
     * @param id int Entity id
     * @param <T> Type
     * @return entity id
     */
    public <T>T getById(int id) {

        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();

        return entity;

    }


    /**
     * Delete a entity
     * @param entity User to be deleted
     */
    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }


    /**
     * Retrieve all the data from the table
     * @return List of data
     */
    public List<T> getAll() {

        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createQuery(query).getResultList();

        session.close();
        return list;
    }


    /**
     * update user
     * @param entity  User to be inserted or updated
     * @return id int Entity id
     */
    public int insert(T entity) {

        logger.debug("type " + entity);

        int id;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }


    /**
     * update user
     * @param entity  User to be inserted or updated
     */
    public void saveOrUpdate(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
    }


    /**
     * Get user by property (exact match)
     * sample usage: getByPropertyEqual("lastName", "Curry")
     *
     * @param propertyName entity property to search by
     * @param value value of the property to search for
     * @return list of users meeting the criteria search
     */
    public List<T> getByPropertyEqual(String propertyName, String value) {
        Session session = getSession();

        logger.debug("Searching for user with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<T> entity = session.createQuery(query).getResultList();

        session.close();
        return entity;
    }


    /**
     * Get user by property (like)
     * sample usage: getByPropertyLike("lastName", "C")
     *
     * @param propertyName entity property to search by
     * @param value value of the property to search for
     * @return list of users meeting the criteria search
     */
    public List<T> getByPropertyLike(String propertyName, String value) {
        Session session = getSession();

        logger.debug("Searching for user with {} = {}", propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<T> entity = session.createQuery(query).getResultList();
        session.close();
        return entity;
    }


    /**
     * get data using multiple properties and optional limit number
     * @param entities Map of entities
     * @param limit set limint on the number of rows in the query
     * @return List of values selected using multiple properties
     */
    public List<T> getByMultiplePropertiesTopClause(Map<String, Map<String, String>> entities, int limit) {

        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(type);

        Root<T> root = query.from(type);

        List<Predicate> predicates = new ArrayList<>();
        List<T> result;


        for (Map.Entry<String, Map<String, String>> firstEntry : entities.entrySet()) {

            String entity = firstEntry.getKey();
            Map<String, String> properties = firstEntry.getValue();

            for (Map.Entry<String, String> secondEntry : properties.entrySet()) {

                if (entity.isEmpty()) {

                    predicates.add(builder.equal(root.get(secondEntry.getKey()), secondEntry.getValue()));
                    break;
                }
                predicates.add(builder.equal(root.get(entity).get(secondEntry.getKey()), secondEntry.getValue()));
            }

        }

        query.select(root).where(predicates.toArray(new Predicate[]{}));

        result = limit == 0 ? session.createQuery(query).getResultList() : session.createQuery(query).setMaxResults(limit).getResultList();

        logger.info(limit);
        logger.info("list of steps " + result);

        return result;
    }


    /**
     * Get session
     * @return Session (start session)
     */
    private Session getSession() {

        return SessionFactoryProvider.getSessionFactory().openSession();

    }

}
