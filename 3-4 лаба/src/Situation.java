import items.Fallable;
import living.LivingEntity;
import places.Place;

public record Situation(LivingEntity ent, Fallable[] FallingItems, int currentTime, Place place) {
    public void runSituation() {

        for(Fallable item : this.FallingItems) {
            item.fall(this.ent);
        }

        this.place.sleepHere(this.currentTime(), this.ent);
        System.out.println();
    }
}