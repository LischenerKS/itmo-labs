package places.flats;

import living.LivingEntity;
import places.Place;

public class OwnFlat extends Place {
    @Override
    protected void displayMessageAfterSleep(LivingEntity entity) {
        System.out.printf("%s прекрасно выспался в своей собственной квартире%n", entity.getName());
    }
}