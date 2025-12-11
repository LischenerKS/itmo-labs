import living.LivingEntity;
import places.Place;
import places.Sleepable;
import sleepiness.SleepinessReason;


public record Situation(LivingEntity ent, SleepinessReason[] sleepinessReasons, int currentTime, Sleepable place) {
    // время указывается в 24-ом формате
    public void runSituation() {

        for (SleepinessReason reason : sleepinessReasons) {
            ent.applySleepinessReason(reason);
        }

        place.sleepHere(this.currentTime(), this.ent);
        System.out.println();
    }
}
