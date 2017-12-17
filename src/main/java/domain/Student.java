package domain;

import json.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {

    protected final Tuple<String, Integer>[] exams;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super(name, surname, year);
        this.exams = exams;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonPair name = new JsonPair("name", new JsonString(this.name));
        JsonPair surname = new JsonPair("surname", new JsonString(this.surname));
        JsonPair year = new JsonPair("year", new JsonNumber(this.year));

        JsonObject[] examsList = new JsonObject[this.exams.length];
        for (int i = 0; i < exams.length; i++) {
            examsList[i] = new JsonObject(new JsonPair(exams[i].key, new JsonNumber(exams[i].value)));
        }

        JsonPair exams = new JsonPair("exams", new JsonArray(examsList));
        return new JsonObject(name, surname, year, exams);
    }
}
