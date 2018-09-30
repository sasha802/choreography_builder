package dance.builder.persistence;

import dance.builder.entity.CustomSteps;
import dance.builder.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CustomStepsDAO {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public List<CustomSteps> getByCustomStepsPropertyEqual(String propertyName, User value) {
        Session session = getSession();

        logger.debug("Searching for user with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<CustomSteps> query = builder.createQuery(CustomSteps.class);
        Root<CustomSteps> root = query.from( CustomSteps.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<CustomSteps> entity = session.createQuery( query ).getResultList();

        session.close();
        return entity;
    }

    private Session getSession() {

        return SessionFactoryProvider.getSessionFactory().openSession();

    }
}
