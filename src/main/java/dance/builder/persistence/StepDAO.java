package dance.builder.persistence;

import dance.builder.entity.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.*;
import java.util.List;

public class StepDAO {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();


    public List<Step> getStepByDance(String propertyOne, String propertyTwo, String value, int id, int numberOfSteps) {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Step.class);

        Root<Step> root = query.from(Step.class);

        Predicate predicate = builder.and(
                builder.equal(root.get(propertyOne).get("id"), id),
                builder.equal(root.get(propertyTwo), value)
        );

        query.where(predicate);
        List<Step> steps = session.createQuery(query).setMaxResults(numberOfSteps).getResultList();
        logger.info(numberOfSteps);
        logger.info("list of steps " + steps);

        return steps;

    }






}
