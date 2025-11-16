/*
    https://pokemondb.net/move/aerial-ace
   *Класс атаки Aerial Ace
    Реализован 
*/

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

public final class AerialAce extends PhysicalMove {
    private static final Type TYPE = Type.FLYING;
    private static final double POW = 60;
    private static final double ACC = Double.POSITIVE_INFINITY;

    public AerialAce() {
        super(TYPE, POW, ACC);
    }

    @Override
    protected String describe() {
        return "use Aerial Ace";
    }
}
