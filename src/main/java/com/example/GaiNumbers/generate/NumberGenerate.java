package com.example.GaiNumbers.generate;

import java.util.*;

public class NumberGenerate {

    Random random = new Random();

    char[] letters = new char[] {'A'};

//    letters[random.nextInt(11)]

    String randomNumber() {
        return "A" + "" + random.nextInt(10)
                + random.nextInt(10) + random.nextInt(10) + "" +
                "A" + "" + "A" + " 116RUS";
    }

    public String rand(List<String> numbers) {

        String s = randomNumber();

        Set<String> buf = new HashSet<>(numbers);

        if (buf.size() > 999)
            return "Error";

        while (numbers.contains(s))
            s = randomNumber();

        return s;
    }


    public String nextNumber(String findLast, List<String> list) {

        if (list.isEmpty())
            return "A000AA 116RUS";

        StringBuilder s = new StringBuilder(findLast);

        char[] num = new char[s.length()];
        int[] letter = new int[3];

        for (int i = 0; i < s.length(); i++) {
            num[i] = s.charAt(i);
        }

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == num[0])
                letter[0] = i;
            if (letters[i] == num[4])
                letter[1] = i;
            if (letters[i] == num[5])
                letter[2] = i;
        }



        if (num[1] == '9' && num[2] == '9' && num[3] == '9') {
            num[1] = '0';
            num[2] = '0';
            num[3] = '0';
//            num[5] = letters[letter[2] + 1];
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

//        if (num[5] == letters[letters.length-1]) {
//            num[5] = letters[0];
//            num[4] = letters[letter[1] + 1];
//            if (num[4] == letters[letters.length-1]) {
//                num[1] = letters[0];
//                num[0] = letters[letter[0] + 1];
//            }
//        }

        s = new StringBuilder();
        for (char c : num) {
            s.append(c);
        }


        return s.toString();
    }

    public String checkFindLast(String s, List<String> list) {

        while (list.contains(s))
            s = nextNumber(s, list);
        return s;
    }

    public Integer generateId(List<Integer> list, Integer lastId) {
        int id;

        Collections.sort(list);

        if (list.isEmpty())
            id = 0;
        else
            id = lastId + 1;
        return id;
    }
}
