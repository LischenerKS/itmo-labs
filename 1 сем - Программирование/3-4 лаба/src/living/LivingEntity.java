package living;

import exceptions.EntityIsDeadException;
import sleepiness.SleepinessReason;

abstract public class LivingEntity {
    protected String name;
    protected int hp;
    protected int sleepiness;

    abstract public void applySleepinessReason(SleepinessReason reason);

    abstract public void isAlive() throws EntityIsDeadException;

    final public String getName() {
        return this.name;
    }

    final public int getSleepiness() {
        return this.sleepiness;
    }
}
