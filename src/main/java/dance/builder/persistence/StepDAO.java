package dance.builder.persistence;

import dance.builder.entity.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.*;
import java.util.List;

public class StepDAO {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public List<Step> getAllSteps() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Step> query = builder.createQuery(Step.class);
        Root<Step> root = query.from(Step.class);
        List<Step> steps = session.createQuery(query).getResultList();

        session.close();

        return steps;

    }

    public List<Step> getStepsByLevel(String level) {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Step> query = builder.createQuery(Step.class);
        Root<Step> root = query.from(Step.class);
        Expression<String> propertyPath = root.get("level");
        query.where(builder.like(propertyPath, "%" + level + "%"));
        List<Step> steps = session.createQuery(query).getResultList();
        session.close();

        return steps;

    }


    public List<Step> getStepByDance(String level, int danceId) {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Step.class);

        Root<Step> root = query.from(Step.class);
        Predicate predicate = builder.and(
                builder.equal(root.get("danceId"), danceId),
                builder.equal(root.get("level"), level)
        );

        query.where(predicate);
        List<Step> steps = session.createQuery(query).getResultList();

        return steps;


    }



}
