package domain;

import json.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {

    protected final String name;
    protected final String surname;
    protected final Integer year;
    protected final Tuple<String, Integer>[] exams;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.exams = exams;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonPair name = new JsonPair("name", new JsonString(this.name));
        JsonPair surname = new JsonPair("surname", new JsonString(this.surname));
        JsonPair year = new JsonPair("year", new JsonNumber(this.year));

        List<Json> examsList = new LinkedList<>();
        for (Tuple<String, Integer> exam: exams){
            examsList.add(new Exam(exam));
        }

        JsonPair exams = new JsonPair("exams", new JsonArray(examsList));
        return new JsonObject(name, surname, year, exams);
    }
}
