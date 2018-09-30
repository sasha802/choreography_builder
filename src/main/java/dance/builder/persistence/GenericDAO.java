package dance.builder.persistence;

import dance.builder.entity.CustomSteps;
import dance.builder.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class GenericDAO<T> {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private Class<T> type;

    public GenericDAO(Class<T> type) {

        this.type = type;

    }

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
     */
    public int insert(T entity) {

        logger.debug("type " + entity);

        int id = 0;
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
        CriteriaQuery<T> query = builder.createQuery( type );
        Root<T> root = query.from( type );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<T> entity = session.createQuery( query ).getResultList();

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



    private Session getSession() {

        return SessionFactoryProvider.getSessionFactory().openSession();

    }

}
