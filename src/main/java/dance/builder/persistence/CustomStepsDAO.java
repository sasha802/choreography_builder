/*
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
import javax.persistence.criteria.*;

public class CustomStepsDAO {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public List<CustomSteps> getByCustomStepsPropertyEqual(String propertyName, User value) {

        Session session = getSession();

        logger.debug("Searching for user with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<CustomSteps> query = builder.createQuery(CustomSteps.class);
        Root<CustomSteps> root = query.from( CustomSteps.class );

        Predicate predicate = builder.and(
                builder.equal(root.get(propertyName), value),
                builder.equal(root.get("deleted"), 0)
        );

        query.where(predicate);
        List<CustomSteps> customSteps = session.createQuery(query).getResultList();

        session.close();
        return customSteps;

    }


    private Session getSession() {

        return SessionFactoryProvider.getSessionFactory().openSession();

    }
}
*/
