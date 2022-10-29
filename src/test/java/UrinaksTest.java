import org.example.Urinals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UrinalsTest {
    @Test
    public void testValidString1()
    {
        System.out.println("========= sai viswas == TEST ONE EXECUTED =========");
        Urinals urinal=new Urinals();
        String urinal_status="01000";
        assertTrue(urinal.isValid(urinal_status));
    }
    @Test
    public void testValidString2()
    {
        System.out.println("========= sai viswas == TEST TWO EXECUTED =========");
        Urinals urinal=new Urinals();
        String test_status="0111";
        assertFalse(urinal.isValid(test_status));
    }
    @Test
    public void testValidString3()
    {
        System.out.println("========= sai viswas == TEST THREE EXECUTED =========");
        Urinals urinal=new Urinals();
        assertTrue(urinal.isValid(null));
    }
    @Test
    public void testValidString4()
    {
        System.out.println("========= sai viswas == TEST FOUR EXECUTED =========");
        Urinals urinal=new Urinals();
        String test_status="1100";
        assertFalse(urinal.isValid(test_status));
    }

    @Test
    public void testValidString5()
    {
        System.out.println("========= sai viswas == TEST FIVE EXECUTED =========");
        Urinals urinal=new Urinals();
        String test_status="10001";
        assertEquals(1,urinal.getUrinalStatus(test_status));
    }

    @Test
    public void testValidString6()
    {
        System.out.println("========= sai viswas == TEST SIX EXECUTED =========");
        Urinals urinal=new Urinals();
        String test_status="00000";
        assertEquals(3,urinal.getUrinalStatus(test_status));
    }

    @Test
    public void testValidString7()
    {
        System.out.println("========= sai viswas == TEST SEVEN EXECUTED =========");
        Urinals urinal=new Urinals();
        String test_status="01000";
        assertEquals(1,urinal.getUrinalStatus(test_status));
    }

    @Test
    public void testValidString8()
    {
        System.out.println("========= sai viswas == TEST EIGHT EXECUTED =========");
        Urinals urinal=new Urinals();
        String test_status="011";
        assertEquals(-1,urinal.getUrinalStatus(test_status));
    }
}


