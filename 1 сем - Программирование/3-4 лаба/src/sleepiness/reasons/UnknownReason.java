package sleepiness.reasons;

import living.Person;
import sleepiness.SleepinessReason;

public class UnknownReason extends SleepinessReason {
    private int sleepiness;

    public UnknownReason() {
        this.sleepiness = (int) (Math.random() * 100);
        ;
    }

    @Override
    protected void doApply(Person person) {
        int personSleepiness = person.getSleepiness();
        person.setSleepiness(personSleepiness + sleepiness);
    }

    @Override
    protected void message(Person person) {
        System.out.printf("Человека %s по неизвестной причине потянуло спать%n", person.getName());
//        System.out.printf("Наложено %d сонливости%n", this.sleepiness);
    }
}
