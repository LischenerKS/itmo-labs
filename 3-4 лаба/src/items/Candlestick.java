package items;

import living.LivingEntity;
import sleepiness.SleepinessReason;

public class Candlestick implements Fallable {
    private SleepinessReason sleepinessReason;

    public Candlestick(SleepinessReason sleepinessReason) {
        this.sleepinessReason = sleepinessReason;
    }

    public Candlestick() {
        this.sleepinessReason = SleepinessReason.CANDLESTICK_TO_HEAD_HIT;
    }

    public void fall(LivingEntity entity) {
        System.out.println("Откуда-то упал подсвечник");
        entity.applySleepinessReason(this.sleepinessReason);
    }
}