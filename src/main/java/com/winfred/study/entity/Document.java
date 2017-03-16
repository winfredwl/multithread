package com.winfred.study.entity;

import java.util.Random;

/**
 * @author Winfred
 * @since 2017/3/16
 */
public class Document {

    private String words[] = {"the", "hello", "goodbye", "packet", "java", "thread", "pool", "random", "class", "main"};

    public String[][] generateDocument(int numLines, int numWords, String word) {
        int counter = 0;
        String document[][] = new String[numLines][numWords];
        Random random = new Random();
        for (int i = 0; i < numLines; i++) {
            for (int j = 0; j < numWords; j++) {
                int index = random.nextInt(words.length);
                document[i][j] = words[index];
                if (document[i][j].equals(word)) {
                    counter++;
                }
            }
        }
        System.out.println("Document: " + word + " appears " + counter + " times in the document");

        return document;
    }
}
