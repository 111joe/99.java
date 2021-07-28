package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class QuestionJSON {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static File file = new File("questions.json");

    public static void main(String[] args) {

        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        String [] answers1 = {"1. Мадрид", "2. Каир", "3. Порто", "4. София"};
        String [] answers2 = {"1. Мадрид", "2. Каир", "3. Порто", "4. София"};
        String [] answers3 = {"1. Мадрид", "2. Каир", "3. Порто", "4. София"};
        String [] answers4 = {"1. Мадрид", "2. Каир", "3. Порто", "4. София"};

        Container [] aq = new Container[5];


        Container question = new Container("Столица Испании?", answers1, 1);
        aq[0] = question;
        Container question2 = new Container("Столица Португалии?", answers2, 3);
        aq[1] = question2;
        Container question3 = new Container("Столица Египта?", answers3, 2);
        aq[2] = question3;
        Container question4 = new Container("Столица Болгарии?", answers4, 4);
        aq[3] = question4;
        Container question5 = new Container("?", "!",0);
        aq[4] = question5;

//        SingleChoiceQuestion [] arraySCQ = {question, question2, question3, question4};

        writeToJSON(aq);
        QuestionJSON qs = new QuestionJSON();
        System.out.println(Arrays.toString(qs.SCQreadFromJSON()));




    }

    static void writeToJSON (Container[] array)  {

        try {
            objectMapper.writeValue(file, array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public SingleChoiceQuestion[] SCQreadFromJSON () {

        SingleChoiceQuestion[] arrayQ = new SingleChoiceQuestion[0];
        try {
            arrayQ = objectMapper.readValue(file, SingleChoiceQuestion[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayQ;
    }

//    public AbstractQuestion [] TQreadFromJSON () {
//
//        AbstractQuestion [] arrayQ = new AbstractQuestion[0];
//        try {
//            arrayQ = objectMapper.readValue(file, TextQuestion[].class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return arrayQ;
//    }


}


