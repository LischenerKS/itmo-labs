/*
    https://pokemondb.net/pokedex/oricorio (Pom-Pom style)
   *Класс покемона Oricorio-Pom-Pom
    Реализован
*/

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public final class OricorioPomPom extends Pokemon {
    private final double HP = 75;
    private final double ATT = 70;
    private final double DEF = 70;
    private final double SP_ATT = 98;
    private final double SP_DEF = 70;
    private final double SPEED = 93;

    public OricorioPomPom(String name, int level) {
        super(name, level);
        super.setType(Type.ELECTRIC, Type.FLYING);
        super.setStats(HP, ATT, DEF, SP_ATT, SP_DEF, SPEED);

        TeeterDance att1 = new TeeterDance();
        super.addMove(att1);

        AirSlash att2 = new AirSlash();
        super.addMove(att2);

        Swagger att3 = new Swagger();
        super.addMove(att3);

        AerialAce att4 = new AerialAce();
        super.addMove(att4);
    }
}
