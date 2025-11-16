/*
    https://pokemondb.net/move/air-slash
   *Класс атаки Air Slash
    Реализован 
*/

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public final class AirSlash extends SpecialMove {
    private static final Type TYPE = Type.FLYING;
    private static final double POW = 75;
    private static final double ACC = 0.95;

    public AirSlash() {
        super(TYPE, POW, ACC);
    }

    @Override
    protected String describe() {
        return "use Air Slash";
    }

    @Override
    protected void applyOppEffects(Pokemon def) {
        //? рассчет шанса математически верен?
        boolean isFlinchUsed = Math.random() < 1 / 3;
        if (isFlinchUsed) {
            Effect.flinch(def);
        }
    }
}
