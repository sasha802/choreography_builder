package dance.builder.persistence;

import dance.builder.entity.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
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

}