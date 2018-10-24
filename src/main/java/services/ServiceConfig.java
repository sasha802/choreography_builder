package services;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("/service")
public class ServiceConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {

        HashSet set = new HashSet<Class<?>>();
        set.add(StepProcessor.class);
        set.add(DanceMovementProcessor.class);
        set.add(DanceTechniqueProcessor.class);

        return set;


    }
}
