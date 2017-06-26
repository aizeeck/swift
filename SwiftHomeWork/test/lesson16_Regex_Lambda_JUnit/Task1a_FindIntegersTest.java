package lesson16_Regex_Lambda_JUnit;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by aizeeck on 12.06.17.
 */
public class Task1a_FindIntegersTest {
    @Test
    public void retrieve4Numbers() throws Exception {
        Task1a_FindIntegers findIntegers = new Task1a_FindIntegers();
        assertTrue(findIntegers.retrieveNumbers(" this9, -is 645 test -65 str--987565ing ").size() == 3);
    }
}