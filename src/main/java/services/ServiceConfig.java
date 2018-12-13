package services;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


/**
 * @author oponomarova
 */
@ApplicationPath("/service")
public class ServiceConfig extends Application {


    /**
     * Add classes to the hash set
     * @return set of the DanceMovementProcessor and StepProcessor classes
     */
    @Override
    public Set<Class<?>> getClasses() {

        HashSet set = new HashSet<Class<?>>();
        set.add(StepProcessor.class);
        set.add(DanceMovementProcessor.class);

        return set;
    }
}
