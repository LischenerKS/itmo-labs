/*
    https://pokemondb.net/move/double-team
   *Класс атаки Double Team
    Реализован
*/

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public final class DoubleTeam extends StatusMove {
    private static final Type TYPE = Type.NORMAL;
    private static final double POW = 0;
    private static final double ACC = 1;

    public DoubleTeam() {
        super(TYPE, POW, ACC);
    }

    @Override
    protected String describe() {
        return "using Double Team";
    }

    @Override
    protected void applySelfEffects(Pokemon att) {
        att.setMod(Stat.EVASION, +1);
    }
}
