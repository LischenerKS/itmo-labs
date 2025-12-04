package sleepiness;

import exceptions.PersonIsDeadException;
import living.Person;

public abstract class SleepinessReason {
    abstract protected void message(Person person);

    abstract protected void doApply(Person person) throws PersonIsDeadException;

    public void apply(Person person) {
        doApply(person);
        message(person);
    }

}


