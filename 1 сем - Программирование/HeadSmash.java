/*
    https://pokemondb.net/move/head-smash
   *Класс атаки Head Smash
    Реализован
*/

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public final class HeadSmash extends PhysicalMove {
    private static final Type TYPE = Type.ROCK;
    private static final double POW = 150;
    private static final double ACC = 0.8;

    public HeadSmash() {
        super(TYPE, POW, ACC);
    }
    
    @Override
    protected String describe() {
        return "use Facade";
    }
    
    @Override
    protected double calcBaseDamage(Pokemon att, Pokemon def) {
        double damage = super.calcBaseDamage(att, def);
        int selfDamage = (int) (-1 * damage / 2);
        att.setMod(Stat.HP, selfDamage);
        return damage;
    }
}
