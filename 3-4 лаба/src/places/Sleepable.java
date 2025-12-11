package places;

import exceptions.BigCommotionException;
import living.LivingEntity;

public interface Sleepable {
    public void sleepHere(int current_time, LivingEntity entity) throws BigCommotionException;
}
