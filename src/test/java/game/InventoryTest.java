package game;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class InventoryTest {
    
    @Test 
    public void testAddItemToEmptyInventory() {
        Inventory inventory = new Inventory(3);
        Item item = new Item('a', Color.WHITE, "Sword", null);

        inventory.add(item);
        assertEquals(item, inventory.get(0));
    }

    @Test 
    public void testAddItemToNextAvailableSlot() {
        Inventory inventory = new Inventory(3);
        Item firstItem = new Item('a', Color.WHITE, "Sword", null);
        Item secondItem = new Item('b', Color.WHITE, "Shield", null);

        inventory.add(firstItem);
        inventory.add(secondItem);

        assertEquals(firstItem, inventory.get(0));
        assertEquals(secondItem, inventory.get(1));
    }

    @Test 
    public void testMaxInventorySlot() {
        Inventory inventory = new Inventory(3);
        Item firstItem = new Item('a', Color.WHITE, "Sword", null);
        Item secondItem = new Item('b', Color.WHITE, "Shield", null);
        Item thirdItem = new Item('c', Color.WHITE, "Boomerang", null);

        inventory.add(firstItem);
        inventory.add(secondItem);
        inventory.add(thirdItem);

        assertEquals(firstItem, inventory.get(0));
        assertEquals(secondItem, inventory.get(1));
        assertEquals(thirdItem, inventory.get(2));
        assertTrue(inventory.isFull());
    }

    @Test 
    public void testOverMaxInventorySlot() {
        Inventory inventory = new Inventory(3);
        Item firstItem = new Item('a', Color.WHITE, "Sword", null);
        Item secondItem = new Item('b', Color.WHITE, "Shield", null);
        Item thirdItem = new Item('c', Color.WHITE, "Boomerang", null);
        Item fourthItem = new Item('d', Color.WHITE, "Potion", null);

        inventory.add(firstItem);
        inventory.add(secondItem);
        inventory.add(thirdItem);
        inventory.add(fourthItem);

        assertFalse(inventory.contains(fourthItem));
        assertTrue(inventory.isFull());
    }
}
