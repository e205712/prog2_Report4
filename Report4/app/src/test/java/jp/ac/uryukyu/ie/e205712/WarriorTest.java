package jp.ac.uryukyu.ie.e205172;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import jp.ac.uryukyu.ie.e205712.*;

public class WarriorTest {
    @Test
    void warriorAttackTest() {
        int defaultHeroHp = 1000;
        int defaultSlimeHp = 300;
        int defaultDeamonHp = 2000;
        int defaultSatanHp = 10000;
        
        Warrior demoWarrior = new Warrior("デモ戦士", defaultHeroHp, 100);

        Enemy slime = new Enemy("スライムもどき",defaultSlimeHp, 30);
        demoWarrior.attackWithWeponSkill(slime);
        int damage1 = defaultSlimeHp - slime.getHitPoint();
        assertEquals(demoWarrior.getAttack()*1.5,damage1);

        Enemy deamon = new Enemy("悪魔もどき", defaultDeamonHp, 200);
        demoWarrior.attackWithWeponSkill(deamon);
        int damage2 = defaultDeamonHp - deamon.getHitPoint();
        assertEquals(demoWarrior.getAttack()*1.5,damage2);

        Enemy satan = new Enemy("魔王もどき", defaultSatanHp, 1000);
        demoWarrior.attackWithWeponSkill(satan);
        int damage3 = defaultSatanHp - satan.getHitPoint();
        assertEquals(demoWarrior.getAttack()*1.5,damage3);
    }
}
