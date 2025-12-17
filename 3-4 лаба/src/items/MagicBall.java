package items;

import living.LivingEntity;
import sleepiness.SleepinessReason;

public class MagicBall implements Fallable {
    private SleepinessReason sleepinessReason;

    public MagicBall(SleepinessReason sleepinessReason) {
        this.sleepinessReason = sleepinessReason;
    }

    public MagicBall() {
        this.sleepinessReason = SleepinessReason.UNKNOWN_REASON;
    }

    public void fall(LivingEntity entity) {
        System.out.println("Откуда-то упал магический шар");
        entity.applySleepinessReason(this.sleepinessReason);
    }
}