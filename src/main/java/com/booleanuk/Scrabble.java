package com.booleanuk;

import com.sun.source.tree.ArrayTypeTree;

import java.util.*;

public class Scrabble {
    private String word;

    public Scrabble(String word) {
        this.word = word;
    }

    public int score() {

        if(this.word == null || this.word.isEmpty() || this.word.isBlank() || this.word.equals("\n\r\t\b\f"))
            return 0;

        //Tildeler poeng til vær bokstav
        ArrayList<Character> group1 = new ArrayList<>(List.of('A','E','I','U','O','U','L','N','R','S','T'));
        ArrayList<Character> group2 = new ArrayList<>(List.of('D', 'G'));
        ArrayList<Character> group3 = new ArrayList<>(List.of('B', 'C', 'M', 'P'));
        ArrayList<Character> group4 = new ArrayList<>(List.of('F', 'H', 'V', 'W', 'Y'));
        ArrayList<Character> group5 =  new ArrayList<>(List.of('K'));
        ArrayList<Character> group8 =  new ArrayList<>(List.of('J', 'X'));
        ArrayList<Character> group10 = new ArrayList<>(List.of('Q', 'Z'));
        ArrayList<Character> group11 = new ArrayList<>(List.of('{', '}','[',']'));

        HashMap<Character,Integer> map = new HashMap<>();
        group1.forEach(x-> map.put(x,1));
        group2.forEach(x-> map.put(x,2));
        group3.forEach(x-> map.put(x,3));
        group4.forEach(x-> map.put(x,4));
        group5.forEach(x-> map.put(x,5));
        group8.forEach(x-> map.put(x,8));
        group10.forEach(x-> map.put(x,10));

        int count = 0;
        //Deler opp word i bokstaver
       char[] bokstaver = this.word.toUpperCase().toCharArray();

        //Beregner poeng basert på bokstav
        int sum = 0;
        for (int i = 0; i < bokstaver.length; i++) {
            sum += map.get(bokstaver[i]);
        }

        return sum;
    }

}
