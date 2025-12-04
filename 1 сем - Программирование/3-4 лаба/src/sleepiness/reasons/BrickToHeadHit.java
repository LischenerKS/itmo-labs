package sleepiness.reasons;

import living.Person;
import sleepiness.SleepinessReason;

public class BrickToHeadHit extends SleepinessReason {
    private final int damage;
    private final int sleepiness;

    public BrickToHeadHit(int damage, int sleepiness) {
        this.damage = damage;
        this.sleepiness = sleepiness;
    }

    @Override
    protected void doApply(Person person) {
        int personHp = person.getHp();
        int personSleepiness = person.getSleepiness();
        person.setHp(personHp - damage);
        person.setSleepiness(personSleepiness + sleepiness);
    }

    @Override
    protected void message(Person person) {
        System.out.printf("Человека %s ударило по голове кирпичом и теперь он хочет спать%n", person.getName());
//        System.out.printf("Наложено %d сонливости%n", this.sleepiness);
//        System.out.printf("Нанесено %d урона%n", this.damage);
    }
}
