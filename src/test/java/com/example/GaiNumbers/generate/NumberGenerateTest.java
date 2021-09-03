package com.example.GaiNumbers.generate;

import com.example.GaiNumbers.service.NumberService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
class NumberGenerateTest {

    final char[] letters = new char[] {'A', 'E', 'T', 'O', 'P', 'H', 'Y', 'K', 'X', 'C', 'B', 'M'};
    NumberGenerate numberGenerate = new NumberGenerate();
    List<String> test;

    @Autowired
    private NumberService numberService;


    boolean chekLetter(char c, char[] arr) {
        for (char value : arr) {
            if (c == value)
                return true;
        }
        return false;
    }

    boolean chekNum(char c) {
        return 47 < c && c < 58;
    }

    @Before
    public void init() {
        test = numberService.findAllByNumbers();
    }

    @Test
    void randomNumber() {
        String s = numberGenerate.randomNumber();
        char[] test = s.toCharArray();

        Assertions.assertEquals(13, test.length);
        Assertions.assertTrue(chekLetter(test[0], letters));
        Assertions.assertTrue(chekNum(test[1]));
        Assertions.assertTrue(chekNum(test[2]));
        Assertions.assertTrue(chekNum(test[3]));
        Assertions.assertTrue(chekLetter(test[4], letters));
        Assertions.assertTrue(chekLetter(test[5], letters));
        Assertions.assertTrue(s.contains(" 116RUS"));
    }

    @Test
    void rand() {
        String num = "A990AA 116RUS";

        init();

        //Заполнить для проверки
        if (test.isEmpty()) {
            for (int i = 0; i < 990; i++) {
                num = numberGenerate.checkFindLast(numberGenerate.nextNumber(numberService.findLast(),
                        numberService.findAllByNumbers()), numberService.findAllByNumbers());

                numberService.insertNumbersValue(numberGenerate.generateId(numberService.findAllByNumberId(),
                        numberService.findByLastId()), num);
            }
        }

        Assertions.assertFalse(test.contains(num));
    }

    @Test
    void nextNumber() {
        List<String> list = new ArrayList<>();
        String num = "A001AA 116RUS";
        list.add(num);

        Assertions.assertEquals(num, numberGenerate.nextNumber("A000AA 116RUS", list));
    }
}