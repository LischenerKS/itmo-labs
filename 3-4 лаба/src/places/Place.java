package places;

import living.LivingEntity;

public abstract class Place {
    public void shoutHere(LivingEntity ent) {
        System.out.printf("%s кричит!%т", ent.getName());
    }
}