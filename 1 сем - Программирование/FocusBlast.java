/*
    https://pokemondb.net/move/focus-blast
   *Класс атаки Focus Blast
    Реализован
*/

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public final class FocusBlast extends SpecialMove{
    private static final Type TYPE = Type.FIGHTING;
    private static final double POW = 120;
    private static final double ACC = 0.7;
    

    public FocusBlast() {
        super(TYPE, POW, ACC);
    }
    
    @Override
    protected String describe() {
        return "use Focus Blast";
    }

    @Override
    protected void applyOppEffects(Pokemon def) {
        //? рассчет шанса математически верен?
        boolean isEffUsed = Math.random() < 0.1;
        if (isEffUsed) {
            def.setMod(Stat.SPECIAL_DEFENSE, -1);
        }
    }
}
