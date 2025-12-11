package living;

import exceptions.EntityIsDeadException;
import sleepiness.SleepinessReason;


public interface LivingEntity {
    void applySleepinessReason(SleepinessReason reason);

    void isAlive() throws EntityIsDeadException;

    String getName();

    int getSleepiness();


}
