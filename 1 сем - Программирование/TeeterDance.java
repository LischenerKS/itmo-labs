/*
    https://pokemondb.net/move/teeter-dance
   *Класс атаки Teeter Dance
    Реализован 
*/

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public final class TeeterDance extends StatusMove {
    private static final Type TYPE = Type.NORMAL;
    private static final double POW = 0;
    private static final double ACC = 1;

    public TeeterDance() {
        super(TYPE, POW, ACC);
    }

    @Override
    protected String describe() {
        return "use Teeter Dance";
    }

    @Override
    protected void applySelfEffects(Pokemon atk) {
        atk.confuse();
    }

    @Override
    protected void applyOppEffects(Pokemon def) {
        def.confuse();
    }
}
