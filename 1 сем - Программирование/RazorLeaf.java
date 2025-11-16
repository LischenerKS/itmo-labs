/*
    https://pokemondb.net/move/razor-leaf
   *Класс атаки RazorLeaf
    Реализован
*/

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import java.lang.Math;

public final class RazorLeaf extends PhysicalMove {
    private static final Type TYPE = Type.GRASS;
    private static final double POW = 55;
    private static final double ACC = 0.95;

    public RazorLeaf() {
        super(TYPE, POW, ACC);
    }

    @Override
    protected String describe() {
        return "use Razor Leaf";
    }

    @Override
    protected double calcCriticalHit(Pokemon att, Pokemon def) {
        boolean isCrit = Math.random() < 0.125;
        int damageMultiplier = 1;

        if (isCrit) {
            damageMultiplier = 2;
        }
        return damageMultiplier;
    }
}
