/*
    https://pokemondb.net/move/swagger
   *Класс атаки Swagger
    Реализован 
*/

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public final class Swagger extends StatusMove {
    private static final Type TYPE = Type.NORMAL;
    private static final double POW = 0;
    private static final double ACC = 0.85;

    public Swagger() {
        super(TYPE, POW, ACC);
    }

    @Override
    protected String describe() {
        return "use Swagger";
    }

    @Override
    protected void applyOppEffects(Pokemon def) {
        Effect.flinch(def);
        def.setMod(Stat.ATTACK, +2);
    }
}
