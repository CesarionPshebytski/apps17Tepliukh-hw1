import domain.BasicStudent;
import domain.Exam;
import domain.Student;
import json.*;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JSONApp {

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
