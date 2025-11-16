/*
    https://pokemondb.net/move/facade
   *Класс атаки Facade
    Реализован
*/

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Status;
import ru.ifmo.se.pokemon.Type;

public final class Facade extends PhysicalMove {
    private static final Type TYPE = Type.NORMAL;
    private static final double POW = 70;
    private static final double ACC = 1;

    public Facade() {
        super(TYPE, POW, ACC);
    }
    
    @Override
    protected String describe() {
        return "use Facade";
    }

    @Override
    protected double calcBaseDamage(Pokemon att, Pokemon def) {
        double damage = super.calcBaseDamage(att, def);

        if ((att.getCondition() == Status.BURN) || (att.getCondition() == Status.POISON) || (att.getCondition() == Status.PARALYZE)) {
            damage *= 2;
        }

        return damage;
    }
}
