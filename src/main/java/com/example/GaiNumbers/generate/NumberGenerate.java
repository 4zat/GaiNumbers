package com.example.GaiNumbers.generate;

import com.example.GaiNumbers.entity.Numbers;
import com.example.GaiNumbers.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerate {

    Random random = new Random();



    char[] letters = new char[] {'А','Е', 'Т', 'О', 'Р', 'Н', 'У', 'К', 'Х', 'С', 'В', 'М'};

    String randomNumber() {
        return letters[random.nextInt(11)] + "" + random.nextInt(10)
                + random.nextInt(10) + random.nextInt(10) + "" +
                letters[random.nextInt(11)] + "" + letters[random.nextInt(11)] + " 116RUS";
    }

    public String rand(List<String> numbers) {
        String s = randomNumber();

        for (String number :
                numbers) {
            if (number.equals(s)) {
                s = randomNumber();
            } else {
                s = randomNumber();
                break;
            }
        }
        return s;
    }
    public String nextNumber(String findLast) {
        String s = findLast;

        char[] num = new char[s.length()];
        int[] letter = new int[3];

        for (int i = 0; i < s.length(); i++) {
            num[i] = s.charAt(i);
        }

        for (int i = 0; i < letters.length; i++) {
            if(letters[i] == num[0])
                letter[0] = i;
            if(letters[i] == num[4])
                letter[1] = i;
            if(letters[i] == num[5])
                letter[2] = i;
        }

        if(s.equals("М999ММ 116RUS")) {
            s = "А000АА 716RUS";
            for (int i = 0; i < s.length(); i++) {
                num[i] = s.charAt(i);
            }
        }

        if(num[1] == '9' && num[2] == '9' && num[3] == '9') {
            num[1] = '0';
            num[2] = '0';
            num[3] = '0';
            num[5] = letters[letter[2] + 1];
        }
        else
        if (num[3] == '9' && num[2] == '9') {
            num[3] = '0';
            num[2] = '0';
            num[1]++;
        }
        else if (num[3] == '9') {
            num[3] = '0';
            num[2]++;
        }
        else
            num[3]++;

        if(num[5] == letters[letters.length-1]) {
            num[5] = letters[0];
            num[4] = letters[letter[1] + 1];
            if (num[4] == letters[letters.length-1]) {
                num[1] = letters[0];
                num[0] = letters[letter[0] + 1];
            }
        }

        s = "";
        for (int i = 0; i < num.length; i++) {
            s = s + num[i];
        }
        return s;
    }
}
