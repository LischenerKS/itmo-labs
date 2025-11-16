/*
    https://pokemondb.net/pokedex/budew
   *Класс покемона Budew
    Реализован
*/

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;


public class Budew extends Pokemon {
    private final double HP = 40;
    private final double ATT = 30;
    private final double DEF = 35;
    private final double SP_ATT = 50;
    private final double SP_DEF = 70;
    private final double SPEED = 55;

    public Budew(String name, int level) {
        super(name, level);
        super.setType(Type.GRASS, Type.POISON);
        super.setStats(HP, ATT, DEF, SP_ATT, SP_DEF, SPEED);

        Facade att1 = new Facade();
        super.addMove(att1);

        ShadowBall att2 = new ShadowBall();
        super.addMove(att2);
    }
}
