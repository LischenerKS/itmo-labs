package living;

import exceptions.BigCommotionException;
import exceptions.PersonIsDeadException;
import places.Place;
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
            reason.apply(this);
        } catch (PersonIsDeadException e) {
            System.out.print(e.getMessage());
            System.out.println(", не удалось применить причину сна");
        }
    }

    @Override
    public void sleep(int current_time, Place place) throws BigCommotionException{
        try {

            this.isAlive();

            int sleepHours = this.sleepiness;

            System.out.printf("На человека %s напала страшная сонливость!%n", this.name);
            int sleepDaysByHours = sleepHours / 24;
            int remainingSleepHours = sleepHours - 24 * sleepDaysByHours;
            System.out.printf("Он проспал %d дней и еще %d часов сверху.%n", sleepDaysByHours, remainingSleepHours);

            System.out.printf("Точнее говоря он заснул в %d часов, а проснулся ", current_time);

            int upTime = (current_time + sleepHours) % 24;
            int sleepDaysByCurrentTime = (current_time + sleepHours) / 24;

            if (sleepDaysByCurrentTime >= 1) {
                System.out.printf("через %d дней ", sleepDaysByCurrentTime);
            }

            System.out.printf("в %d часов.%n", upTime);

            System.out.printf("Проспав таким образом %d часов подряд%n", sleepHours);

            if (place == Place.SOMEONE_ELSES_ROOM) {
                System.out.printf("Человек %s спит в чужом помещении, где никто и не думает его искать%n", this.name);
                throw new BigCommotionException("Произошел большой переполох");
            } else if (place == Place.OWN_FLAT) {
                System.out.printf("Человек %s прекрасно выспался в своей собственной квартире%n", this.name);
            }
        } catch (PersonIsDeadException e) {
            System.out.print(e.getMessage() + ", не удалось уснуть");
            System.out.println();
        } catch (BigCommotionException e) {
            System.out.print(e.getMessage());
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
    public void isAlive() throws PersonIsDeadException {
        if (hp <= 0) {
            throw new PersonIsDeadException(String.format("Человек %s мертв", this.name));
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