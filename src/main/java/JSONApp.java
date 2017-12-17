import domain.BasicStudent;
import domain.Exam;
import domain.Student;
import json.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JSONApp {
    public static void main(String[] args) {
        Json jYear = new JsonNumber(2);
        print(jYear); // 2

        Json jMarks = new JsonArray(new JsonNumber(3), new JsonNumber(4));
        Json jMark = new JsonArray(jMarks, jYear);
        print(jMarks); // [3, 4]

        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));
        JsonPair marks = new JsonPair("marks", jMarks);
        JsonPair year = new JsonPair("year", jYear);
        JsonObject jsonObj = new JsonObject(name, surname, year, marks);
        print(jsonObj); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}
        print(jsonObj.projection("surname", "age", "year", "marks")); // {'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        Student student = new Student(
                "Andrii",
                "Rodionov",
                3,
                new Tuple<>("OOP", 3),
                new Tuple<>("English", 5),
                new Tuple<>("Math", 2)
        );

        BasicStudent basic = new BasicStudent("Andrii",
                "Rodionov",
                3);

        JsonObject jsonObject = student.toJsonObject();
        JsonObject jsonBasic = basic.toJsonObject();
        print(jsonObject);
        print(jsonBasic);

        BasicStudent basicStudent = new BasicStudent("Andrii", "Rodionov", 2);
        print(basicStudent.toJsonObject()); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2}
    }

    private static void print(Json json) {
        System.out.println(json.toJson());
    }


    public static JsonObject sessionResult() {
        Json jYear = new JsonNumber(2);

        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));
        JsonPair year = new JsonPair("year", jYear);
        Exam oop = new Exam(new Tuple<>("OOP", 3));
        Exam english = new Exam(new Tuple<>("English", 5));
        Exam math = new Exam(new Tuple<>("Math", 2));
        JsonArray examsArray = new JsonArray(oop, english, math);
        JsonPair exams = new JsonPair("exams", examsArray);
        return new JsonObject(name, surname, year, exams);
    }
}
