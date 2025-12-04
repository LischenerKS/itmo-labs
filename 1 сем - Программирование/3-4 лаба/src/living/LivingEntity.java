package living;

import exceptions.PersonIsDeadException;
import places.Place;
import sleepiness.SleepinessReason;


public interface LivingEntity {
    void applySleepinessReason(SleepinessReason reason);

    void sleep(int current_time, Place place) throws PersonIsDeadException;

    void isAlive() throws PersonIsDeadException;
}
