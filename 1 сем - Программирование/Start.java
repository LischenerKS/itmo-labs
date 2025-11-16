/*
 *   Author = Lischener Kirill
 *   Group = P3114
 *   Date = 09.10.2025
 */

import ru.ifmo.se.pokemon.Battle;

public class Start {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Budew p1 = new Budew("Budewchik", 1);
        Roselia p2 = new Roselia("Roseliashka", 25);
        Roserade p3 = new Roserade("Roseradka", 1);
        OricorioPomPom p4 = new OricorioPomPom("Popkornchik", 45);
        Cranidos p5 = new Cranidos("Cranidosik", 43);
        Rampardos p6 = new Rampardos("Rampardosik", 58);

        battle.addAlly(p1);
        battle.addAlly(p2);
        battle.addAlly(p5);

        battle.addFoe(p3);
        battle.addFoe(p4);
        battle.addFoe(p6);

        battle.go();
    }
}