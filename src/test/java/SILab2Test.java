import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

@Test
public void testEveryBranch() {

    // Test case 1: Null allItems list
    List<Item> allItems1 = null;
    int payment1 = 100;
    RuntimeException exception1 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems1, payment1));
    assertEquals("allItems list can't be null!", exception1.getMessage());

    // Test case 2: Empty allItems list
    List<Item> allItems2 = Arrays.asList();
    int payment2 = 100;
    boolean result2 = SILab2.checkCart(allItems2, payment2);
    assertTrue(result2);

    // Test case 3: Item with null name and valid barcode
    Item item3 = new Item(null, "123456", 100, 0.1f);
    List<Item> allItems3 = Arrays.asList(item3);
    int payment3 = 10;
    boolean result3 = SILab2.checkCart(allItems3, payment3);
    assertTrue(result3);
    assertEquals("unknown", item3.getName());

    // Test case 4: Item with invalid barcode character
    Item item4 = new Item("Item", "123a56", 100, 0.1f);
    List<Item> allItems4 = Arrays.asList(item4);
    int payment4 = 100;
    RuntimeException exception4 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems4, payment4));
    assertEquals("Invalid character in item barcode!", exception4.getMessage());

    // Test case 5: Item with null barcode
    Item item5 = new Item("Item", null, 100, 0.1f);
    List<Item> allItems5 = Arrays.asList(item5);
    int payment5 = 100;
    RuntimeException exception5 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems5, payment5));
    assertEquals("No barcode!", exception5.getMessage());

    // Test case 6: Item with discount
    Item item6 = new Item("Item", "123456", 100, 0.1f);
    List<Item> allItems6 = Arrays.asList(item6);
    int payment6 = 10;
    boolean result6 = SILab2.checkCart(allItems6, payment6);
    assertTrue(result6);

    // Test case 7: Item without discount
    Item item7 = new Item("Item", "123456", 100, 0f);
    List<Item> allItems7 = Arrays.asList(item7);
    int payment7 = 100;
    boolean result7 = SILab2.checkCart(allItems7, payment7);
    assertTrue(result7);

    // Test case 8: Item price discount barcode condition
    Item item8 = new Item("Item", "0123456", 350, 0.1f);
    List<Item> allItems8 = Arrays.asList(item8);
    int payment8 = 5;
    boolean result8 = SILab2.checkCart(allItems8, payment8);
    assertTrue(result8);

    // Test case 9: Insufficient payment
    Item item91 = new Item("Item1", "123456", 200, 0.1f);
    Item item92 = new Item("Item2", "654321", 150, 0.2f);
    List<Item> allItems9 = Arrays.asList(item91, item92);
    int payment9 = 40;
    boolean result9 = SILab2.checkCart(allItems9, payment9);
    assertFalse(result9);
}

    @Test
    public void testMultipleConditionCoverage() {
        // T && T && T
        Item itemTTT = new Item("Item1", "0123456", 350, 0.1f);
        List<Item> allItemsTTT = Arrays.asList(itemTTT);
        int paymentTTT = 5;
        assertTrue(SILab2.checkCart(allItemsTTT, paymentTTT));

        // T && T && F
        Item itemTTF = new Item("Item2", "1123456", 350, 0.1f);
        List<Item> allItemsTTF = Arrays.asList(itemTTF);
        int paymentTTF = 35;
        assertTrue(SILab2.checkCart(allItemsTTF, paymentTTF));

        // T && F && T
        Item itemTFT = new Item("Item3", "0123456", 350, 0.0f);
        List<Item> allItemsTFT = Arrays.asList(itemTFT);
        int paymentTFT = 350;
        assertTrue(SILab2.checkCart(allItemsTFT, paymentTFT));

        // T && F && F
        Item itemTFF = new Item("Item4", "1123456", 350, 0.0f);
        List<Item> allItemsTFF = Arrays.asList(itemTFF);
        int paymentTFF = 350;
        assertTrue(SILab2.checkCart(allItemsTFF, paymentTFF));

        // F && T && T
        Item itemFTT = new Item("Item5", "0123456", 250, 0.1f);
        List<Item> allItemsFTT = Arrays.asList(itemFTT);
        int paymentFTT = 25;
        assertTrue(SILab2.checkCart(allItemsFTT, paymentFTT));

        // F && T && F
        Item itemFTF = new Item("Item6", "1123456", 250, 0.1f);
        List<Item> allItemsFTF = Arrays.asList(itemFTF);
        int paymentFTF = 25;
        assertTrue(SILab2.checkCart(allItemsFTF, paymentFTF));

        // F && F && T
        Item itemFFT = new Item("Item7", "0123456", 250, 0.0f);
        List<Item> allItemsFFT = Arrays.asList(itemFFT);
        int paymentFFT = 250;
        assertTrue(SILab2.checkCart(allItemsFFT, paymentFFT));

        // F && F && F
        Item itemFFF = new Item("Item8", "1123456", 250, 0.0f);
        List<Item> allItemsFFF = Arrays.asList(itemFFF);
        int paymentFFF = 250;
        assertTrue(SILab2.checkCart(allItemsFFF, paymentFFF));
    }
}

