package living;

import exceptions.EntityIsDeadException;
import sleepiness.SleepinessReason;

public class Person extends LivingEntity {
    public Person(String name) {
        this.name = name;
        this.sleepiness = 0;
        this.hp = 100;
    }

    @Override
    public void applySleepinessReason(SleepinessReason reason) {
        try {
            this.isAlive();

            if (reason == SleepinessReason.UNKNOWN_REASON) {
                this.sleepiness += (int)(Math.random() * 100);
                System.out.printf("Человека %s по неизвестной причине потянуло спать%n", this.name);
            }

            else if (reason == SleepinessReason.BRICK_TO_HEAD_HIT) {
                this.hp -= 50;
                this.sleepiness += 20;
                System.out.printf("Человека %s ударило по голове кирпичом! Теперь он хочет спать%n", this.name);
            }

            else if (reason == SleepinessReason.CANDLESTICK_TO_HEAD_HIT) {
                this.hp -= 10;
                this.sleepiness += 5;
                System.out.printf("Человека %s ударило по голове подсвечником! Теперь он хочет спать%n", this.name);
            }

        } catch (EntityIsDeadException e) {
            System.out.print(e.getMessage());
            System.out.println(", не удалось применить причину сна");
        }
    }

    @Override
    public void isAlive() throws EntityIsDeadException {
        if (this.hp <= 0) {
            throw new EntityIsDeadException(String.format("Человек %s мертв", this.name));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof Person other) {
            return this.name.equals(other.name);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return ("Person " + this.name).hashCode();
    }

    public String toString() {
        return "Person {name=\"" + this.name + "\"}";
    }
}
