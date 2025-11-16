/*
    https://pokemondb.net/move/ancient-power
   *Класс атаки Ancient Power
    Реализован 
*/

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public final class AncientPower extends SpecialMove {
    private static final Type TYPE = Type.ROCK;
    private static final double POW = 60;
    private static final double ACC = 1;


    public AncientPower() {
        super(TYPE, POW, ACC);
    }

    @Override
    protected String describe() {
        return "use Ancient Power";
    }

    @Override
    protected void applySelfEffects(Pokemon atk) {
        //? рассчет шанса математически верен?
        boolean isEffUsed = Math.random() < 0.1;
        if (isEffUsed) {
            atk.setMod(Stat.ATTACK, +1);
            atk.setMod(Stat.DEFENSE, +1);
            atk.setMod(Stat.SPECIAL_ATTACK, +1);
            atk.setMod(Stat.SPECIAL_DEFENSE, +1);
            atk.setMod(Stat.SPEED, +1);
        }
    }
}
