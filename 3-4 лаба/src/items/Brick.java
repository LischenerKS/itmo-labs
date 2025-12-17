package items;

import living.LivingEntity;
import sleepiness.SleepinessReason;

public class Brick implements Fallable {
    private SleepinessReason sleepinessReason;

    public Brick(SleepinessReason sleepinessReason) {
        this.sleepinessReason = sleepinessReason;
    }

    public Brick() {
        this.sleepinessReason = SleepinessReason.BRICK_TO_HEAD_HIT;
    }

    public void fall(LivingEntity entity) {
        System.out.println("Откуда-то упал кирпич");
        entity.applySleepinessReason(this.sleepinessReason);
    }
}
