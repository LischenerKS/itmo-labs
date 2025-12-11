package places.flats;

import exceptions.BigCommotionException;
import exceptions.EntityIsDeadException;
import living.LivingEntity;
import places.Place;
import places.Sleepable;

public class SomeoneElsesFlat extends Place implements Sleepable {
    @Override
    public void sleepHere(int current_time, LivingEntity entity) throws BigCommotionException {
        try {
            entity.isAlive();

            int sleepHours = entity.getSleepiness();

            System.out.printf("На %s напала страшная сонливость!%n", entity.getName());
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

            System.out.printf("%s спит в чужой квартире, где никто и не думает его искать%n", entity.getName());
            throw new BigCommotionException("Произошел большой переполох");
        } catch (EntityIsDeadException e) {
            System.out.print(e.getMessage() + ", не удалось уснуть");
            System.out.println();
        } catch (BigCommotionException e) {
            System.out.print(e.getMessage());
        }
    }
}

