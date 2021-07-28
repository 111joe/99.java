package com.company;

import java.util.TreeSet;

public class TextQuestion extends AbstractQuestion{
    TextQuestion(String question, String correctAnswer, TreeSet<String> tags) {

    }
    String correctAnswer;
    String currentAnswer;

    @Override
    Boolean ValidateAnswer() {
        return null;
    }
}
