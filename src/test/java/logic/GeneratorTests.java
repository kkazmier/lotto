package logic;

import com.app.lotto.logic.NumberGenerator;
import org.junit.jupiter.api.Test;

public class GeneratorTests {
    @Test
    void testLottoNumbersGenerator() {
        for(int i=0; i<30; i++){
            System.out.println(NumberGenerator.generateLottoNumbers());
        }
    }
}
