package beans;

import java.io.Serializable;

public class Course implements Serializable {
    private String id;
    private String name;
    private String description;
    private float score;
    private Account teacher;

    public Course(String id, String name, String description, float score, Account teacher) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.score = score;
        this.teacher = teacher;
    }

    public Course(String id, String name, String description, float score) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.score = score;
    }

    public Course() {
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", score=" + score +
                ", teacher=" + teacher +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Account getTeacher() {
        return teacher;
    }

    public void setTeacher(Account teacher) {
        this.teacher = teacher;
    }
}
