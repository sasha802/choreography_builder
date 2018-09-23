package dance.builder.persistence;


import dance.builder.entity.Dance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class DanceDAO {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public List<Dance> getAllDances() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Dance> query = builder.createQuery(Dance.class);
        Root<Dance> root = query.from(Dance.class);
        List<Dance> dances = session.createQuery(query).getResultList();

        session.close();
        return dances;

    }


    public List<Dance> getDanceType(String danceType) {

        logger.info("Dance type " + danceType);

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Dance> query = builder.createQuery(Dance.class);
        Root<Dance> root = query.from(Dance.class);
        Expression<String> propertyPath = root.get("danceName");
        query.where(builder.like(propertyPath, "%" + danceType + "%"));
        List<Dance> steps = session.createQuery(query).getResultList();
        session.close();

        return steps;





    }
}
