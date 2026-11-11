package game;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreatureTest {
    private World world;
    private Creature creature;

    @BeforeEach
    void setUp() {
        Tile[][][] tiles = new Tile[3][3][1];

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                tiles[x][y][0] = Tile.FLOOR;
            }
        }

        world = new World(tiles);

        creature = new Creature(world, '@', Color.GRAY, "josh", 100, 10, 5);

        creature.x = 1;
        creature.y = 1;
        creature.z = 0;
    }

    @Test
    public void hpTestMax() {
        creature.modifyHp(10, "None");
        assertEquals(100, creature.hp());

    }

    @Test
    public void hpTestLower() {
        creature.modifyHp(-50, "None");
        assertEquals(50, creature.hp());
    }

    @Test
    public void hpTestNegative() {
        creature.modifyHp(-105, "No health");
        
        assertEquals(-5, creature.hp());
    }

    @Test
    public void hpTestDeath() {
        new CreatureAi(creature);
        world.add(creature);

        creature.modifyHp(-105, "No health");

        assertEquals(-5, creature.hp());
        assertEquals(null, world.creature(1, 1, 0));
    }

}
