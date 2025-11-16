/*
    https://pokemondb.net/move/shadow-ball
   *Класс атаки ShadowBall
    Реализован
*/

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public final class ShadowBall extends SpecialMove{
    private static final Type TYPE = Type.GHOST;
    private static final double POW = 80;
    private static final double ACC = 1;

    public ShadowBall() {
        super(TYPE, POW, ACC);
    }
    
    @Override
    protected String describe() {
        return "use Shadow Ball";
    }

    @Override
    protected void applyOppEffects(Pokemon def) {
        def.setMod(Stat.SPECIAL_DEFENSE, -1);
    }
}
