package logic;

import com.app.lotto.logic.WinsAnalyser;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinsAnalyserTestSuite {
    WinsAnalyser analyser = new WinsAnalyser();

    @Test
    void testConvertToIntegersSet() {
        String stringNumbers = "01021314";
        Set<Integer> numberSet = new HashSet<>();
        numberSet.add(1);
        numberSet.add(2);
        numberSet.add(13);
        numberSet.add(14);

        assertEquals(numberSet, analyser.convertToIntegersSet(stringNumbers));
    }

    @Test
    void testFindHitsQuantity() {
        String resultNumbers = "010203040506";
        assertEquals(0, analyser.findHitQuantity(resultNumbers, "112233445566"));
        assertEquals(1, analyser.findHitQuantity(resultNumbers, "061122334455"));
        assertEquals(2, analyser.findHitQuantity(resultNumbers, "060533445566"));
        assertEquals(3, analyser.findHitQuantity(resultNumbers, "060433445501"));
        assertEquals(4, analyser.findHitQuantity(resultNumbers, "052204025501"));
        assertEquals(5, analyser.findHitQuantity(resultNumbers, "050301020611"));
        assertEquals(6, analyser.findHitQuantity(resultNumbers, "060504010203"));
    }
}
