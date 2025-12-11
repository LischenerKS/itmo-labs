/*
 * Неизвестно, то ли от удара по голове кирпичом, то ли по какой другой причине,
 * но на Свистулькина напала страшная сонливость, и он проспал весь день, всю ночь
 * и почти все следующее утро.
 *
 * Точнее говоря, он заснул в десять часов утра, а проснулся
 * на следующий день в одиннадцать, проспав, таким образом, двадцать пять часов подряд,
 * то есть целые сутки и еще час в придачу.
 *
 * Если бы Свистулькин заснул в своей квартире,
 * где его могли сразу найти, то ничего особенного не случилось бы, но он спал в чужом
 * помещении, где никто не думал его искать, и из-за этого произошел большой переполох.
 */

import living.Person;
import places.Place;
import sleepiness.SleepinessReason;
import sleepiness.reasons.BrickToHeadHit;
import sleepiness.reasons.UnknownReason;

import java.util.ArrayList;

;

public class Main {
    public static void main(String[] args) {
        Situation[] situations = new Situation[2];
        situations[0] = new Situation("Свистулькин", 9, Place.OWN_FLAT);
        situations[1] = new Situation("Кричалкин", 19, Place.SOMEONE_ELSES_ROOM);

        for (Situation situation : situations) {
            Person person = new Person(situation.name());

            ArrayList<SleepinessReason> sleepinessReasons = new ArrayList<>(2);

            sleepinessReasons.add(new BrickToHeadHit(99, 20));
            sleepinessReasons.add(new UnknownReason());

            for (SleepinessReason reason : sleepinessReasons) {
                person.applySleepinessReason(reason);
            }

            person.sleep(situation.current_time(), situation.place());
            System.out.println();
        }


    }
}