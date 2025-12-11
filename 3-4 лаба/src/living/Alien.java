package living;

import exceptions.EntityIsDeadException;
import sleepiness.SleepinessReason;

public class Alien implements LivingEntity {
    private final String name;
    private int hp;
    private int sleepiness;

    public Alien(String name) {
        this.name = name;
        this.sleepiness = 0; //один поинт = 1 часу сна, но добавляется в 2 раза больше чем человеку
        this.hp = 51;
    }

    public void applySleepinessReason(SleepinessReason reason) {
        try {
            this.isAlive();
            if (reason == SleepinessReason.UNKNOWN_REASON) {
                this.sleepiness += (int) (Math.random() * 100 * 10);
                System.out.printf("Инопланетянина %s по неизвестной причине потянуло спать%n", this.name);

            } else if (reason == SleepinessReason.BRICK_TO_HEAD_HIT) {
                this.hp -= 50;
                this.sleepiness += 20 * 10;
                System.out.printf("Инопланетянина %s ударило по голове кирпичом! Теперь он хочет спать%n", this.name);
            }
        } catch (EntityIsDeadException e) {
            System.out.print(e.getMessage());
            System.out.println(", не удалось применить причину сна");
        }
    }

    @Override
    public void isAlive() throws EntityIsDeadException {
        if (hp <= 0) {
            throw new EntityIsDeadException(String.format("Человек %s мертв", this.name));
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof Alien) {
            Alien other = (Alien) obj;
            return this.name.equals(other.name);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int sum = 0;
        for (int i = 0; i < this.name.length(); i++) {
            sum += (int) this.name.charAt(i);
        }
        return sum;
    }

    @Override
    public String toString() {
        return "alien {" + "name=\"" + this.name + "\"" + "}";
    }

    @Override
    public int getSleepiness() {
        return this.sleepiness;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
