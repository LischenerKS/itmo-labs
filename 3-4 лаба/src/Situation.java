import items.Fallable;
import living.LivingEntity;
import places.Place;

import java.time.LocalDateTime;

public record Situation(LivingEntity ent, Fallable[] FallingItems, LocalDateTime currentTime, Place place) {
    public void runSituation() {

        for(Fallable item : this.FallingItems) {
            item.fall(this.ent);
        }

        this.place.sleepHere(this.currentTime(), this.ent);
        System.out.println();
    }
}