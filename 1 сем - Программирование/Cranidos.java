/*
    https://pokemondb.net/pokedex/cranidos
   *Класс покемона Cranidos
    Реализован
*/

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Cranidos extends Pokemon {
    private final double HP = 67;
    private final double ATT = 125;
    private final double DEF = 40;
    private final double SP_ATT = 30;
    private final double SP_DEF = 30;
    private final double SPEED = 58;

    public Cranidos(String name, int level) {
        super(name, level);
        super.setType(Type.ROCK);         
        super.setStats(HP, ATT, DEF, SP_ATT, SP_DEF, SPEED);
 
        Swagger att1 = new Swagger();
        super.addMove(att1);

        AncientPower att2 = new AncientPower();
        super.addMove(att2);

        HeadSmash att3 = new HeadSmash();
        super.addMove(att3);
    }
}
