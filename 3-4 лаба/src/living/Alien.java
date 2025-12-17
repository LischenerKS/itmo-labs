package living;

import exceptions.EntityIsDeadException;
import sleepiness.SleepinessReason;

public class Alien extends LivingEntity {
    public Alien(String name) {
        this.name = name;
        this.sleepiness = 0;
        this.hp = 51;
    }

    @Override
    public void applySleepinessReason(SleepinessReason reason) {
        try {
            this.isAlive();

            if (reason == SleepinessReason.UNKNOWN_REASON) {
                this.sleepiness += (int)(Math.random() * 100 * 10);
                System.out.printf("Инопланетянина %s по неизвестной причине потянуло спать%n", this.name);
            }

            else if (reason == SleepinessReason.BRICK_TO_HEAD_HIT) {
                this.hp -= 50;
                this.sleepiness += 200;
                System.out.printf("Инопланетянина %s ударило по голове кирпичом! Теперь он хочет спать%n", this.name);
            }

            else if (reason == SleepinessReason.CANDLESTICK_TO_HEAD_HIT) {
                this.hp -= 10;
                this.sleepiness += 50;
                System.out.printf("Инопланетянина %s ударило по голове подсвечником! Теперь он хочет спать%n", this.name);
            }

        } catch (EntityIsDeadException e) {
            System.out.print(e.getMessage());
            System.out.println(", не удалось применить причину сна");
        }
    }

    @Override
    public void isAlive() throws EntityIsDeadException {
        if (this.hp <= 0) {
            throw new EntityIsDeadException(String.format("Инопланетянин %s мертв", this.name));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof Alien other) {
            return this.name.equals(other.name);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return ("Alien " + this.name).hashCode();
    }

    public String toString() {
        return "alien {name=\"" + this.name + "\"}";
    }

}