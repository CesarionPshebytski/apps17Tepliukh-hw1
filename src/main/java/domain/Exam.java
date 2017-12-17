package domain;

import json.*;

public class Exam extends Json {
    protected String course;
    protected Integer mark;
    protected Boolean passed;

    public Exam(Tuple<String, Integer> exam){
        this.course = exam.key;
        this.mark = exam.value;
        this.passed = mark>2;
    }

    @Override
    public String toJson() {
        JsonPair course = new JsonPair("course", new JsonString(this.course));
        JsonPair mark = new JsonPair("mark", new JsonNumber(this.mark));
        JsonPair passed = new JsonPair("passed", new JsonBoolean(this.passed));
        return new JsonObject(course, mark, passed).toJson();
    }
}
