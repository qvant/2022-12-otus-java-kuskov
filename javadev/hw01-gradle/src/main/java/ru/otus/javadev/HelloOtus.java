package ru.otus.javadev;
import com.google.common.base.Splitter;

import java.util.List;

public class HelloOtus {
    public static void main(String[] args) {
        String input = "There is sample sentence";

        List<String> words = Splitter.on(" ").splitToList(input);

        for (String word: words) {
            System.out.println(word);
        }

    }
}