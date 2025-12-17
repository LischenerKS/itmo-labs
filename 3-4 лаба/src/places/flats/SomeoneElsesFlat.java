package places.flats;

import exceptions.BigCommotionException;
import living.LivingEntity;
import places.Place;

public class SomeoneElsesFlat extends Place {
    @Override
    protected void displayMessageAfterSleep(LivingEntity entity) {
        System.out.printf("%s спит в чужой квартире, где никто и не думает его искать%n", entity.getName());
        throw new BigCommotionException("Произошел большой переполох");
    }
}
