package living;

import exceptions.EntityIsDeadException;
import sleepiness.SleepinessReason;

public class Person implements LivingEntity {
    private final String name;
    private int hp;
    private int sleepiness;

    public Person(String name) {
        this.name = name;
        this.sleepiness = 0; //один поинт = 1 часу сна
        this.hp = 100;
    }

    @Override
    public void applySleepinessReason(SleepinessReason reason) {
        try {
            this.isAlive();
            if (reason == SleepinessReason.UNKNOWN_REASON) {
                this.sleepiness += (int) (Math.random() * 100);
                System.out.printf("Человека %s по неизвестной причине потянуло спать%n", this.name);

            } else if (reason == SleepinessReason.BRICK_TO_HEAD_HIT) {
                this.hp -= 50;
                this.sleepiness += 20;
            }
        } catch (EntityIsDeadException e) {
            System.out.print(e.getMessage());
            System.out.println(", не удалось применить причину сна");
        }
    }


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSleepiness() {
        return sleepiness;
    }

    public void setSleepiness(int sleepiness) {
        this.sleepiness = sleepiness;
    }

    public String getName() {
        return name;
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
        } else if (obj instanceof Person) {
            Person other = (Person) obj;
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
        return "Person {" + "name=\"" + this.name + "\"" + "}";
    }
}