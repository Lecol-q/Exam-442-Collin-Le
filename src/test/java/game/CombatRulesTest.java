package game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CombatRulesTest {
    
    @Test
    public void calculateNewHPTest() {
        CombatRules combatRules = new CombatRules();
        assertEquals(60, combatRules.calculateNewHp(50, 100, 10));
        assertEquals(100, combatRules.calculateNewHp(90, 100, 15));
        assertEquals(-10, combatRules.calculateNewHp(10, 100, -20));
    }

    @Test
    public void isDeadTest() {
        CombatRules combatRules = new CombatRules();

        assertFalse(combatRules.isDead(combatRules.calculateNewHp(50, 100, 10)));
        assertFalse(combatRules.isDead(combatRules.calculateNewHp(90, 100, 15)));
        assertTrue(combatRules.isDead(combatRules.calculateNewHp(10, 100, -20)));
    }


}
