package model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private String room;
    private ArrayList<Student> students;

    public String getName() {
        return name;
    }

    public Team(String name, String room) {
        this.name = name;
        this.room = room;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (student.isActive()) {
            students.add(student);
        }

    }

    public Student[] getAllStudents() {
        return students.toArray(new Student[students.size()]); // Convert the 'students' list to an array of Student objects with the same size as the list, and return it
    }

    public void removeStudents(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                students.remove(student);
            }
        }
    }

    public double getAverageGrades() {
        double gennemsnitsKarakter = 0;
        for (int i = 0; i < students.size(); i++) {
            gennemsnitsKarakter += students.get(i).getAverageGrade();
        }
        return gennemsnitsKarakter / (students.size());
    }

    public Student[] highScoreStudents(double minAverage) {
        List<Student> highScoreStudents = new ArrayList<>();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() >= minAverage) {
                highScoreStudents.add(students.get(i));
            }
        }
        return highScoreStudents.toArray(new Student[highScoreStudents.size()]);
    }
}
