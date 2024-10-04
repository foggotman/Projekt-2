package model;

import java.util.ArrayList;

public class Team {
    // Field Variables
    private String name;
    private String room;
    private ArrayList<Student> studentsArray = new ArrayList<>();

    // Constructor
    public Team(String name, String room) {
        this.name = name;
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Student> getStudentsArray() {
        return studentsArray;
    }

    // Simpel metode til at add student til ArrayList, og lidt print til feedback
    public void addStudent(Student student) {
        studentsArray.add(student);
        System.out.println("Student tilføjet: " + student + "\ntil teamet: " + getName());
    }
    // Metode til at printe studerende i ArrayList
    public void printStudents() {
        if (studentsArray.isEmpty()) {
            System.out.println("Listen af studenter er tom.");
        } else {
            for (Student student : studentsArray) {
                System.out.println(student);
            }
        }
    }

    // Metode til at remove student fra ArrayList
    public void removeStudent(String name) {
        for (Student student : studentsArray) {
            if (student.getName().equals(name)) {
                studentsArray.remove(student);
                System.out.println("Studenten med navnet: " + name + "\ner fjernet fra listen.");
                return;
            }
        }
        System.out.println("Studenten med navnet: " + name + "\nkunne ikke findes.");
    }

    // toString (synes stadig det er lidt mærkeligt, men det er vil for at convertere det du returner?)
    public String toString() {
        return name;
    }

    // Metode til at beregne et teams gennemsnits karakter
    public double teamAverage() {
        double totalSum = 0;
        int totalGradeCount = 0;
        if (studentsArray == null ) {
            System.out.println("Listen af studerende har ingen karaktere.");
            return 0;
        } else {
            for (Student student : studentsArray) {
                for (int grade : student.getStudentGrades()) {
                    totalSum += grade;
                    totalGradeCount++;
                }
            }
        }
        return totalSum / totalGradeCount;
    }

    // Metode til at se om studerende "bestod", og hvis de bestod bliver de gemt i en ArrayList
    public Student[] beståetStuderende(double minAverage) {
        ArrayList<Student> achievers = new ArrayList<>();
        for (Student student : studentsArray) {
            if (student.isActive()) {
                int[] grades = student.getStudentGrades();
                double total = 0;
                for (int grade : grades) {
                    total += grade;
                }
                double average = 0;
                if (grades.length >= 0) {
                    average = total / grades.length;
                }
                if (average >= minAverage) {
                    achievers.add(student);
                }
            }
        }
        return achievers.toArray(new Student[0]);
    }


    public int countTeamCorrectAnswers(char[] correctAnswers) {
        int totalCorrect = 0;

        for (Student student : studentsArray) {
            totalCorrect += student.correctAnswers(correctAnswers);
        }
        return totalCorrect;
    }

    // Print for feedback
    public void printTeamAnswers() {
        for (int i = 0; i < studentsArray.size(); i++) {
            System.out.println("Den studerende " + (i + 1) + " svarede: ");
            for (char answer : studentsArray.get(i).getStudentMultipleChoice()) {
                System.out.print(answer + " ");
            }
            System.out.println();
        }
    }

    // Lidt en skidt metode som printer og tæller op korrekte svar for hvert spørgsmål
    public void printStatistics(char[] correctAnswers) {
        System.out.println("Navn    | Karakter Gennemsnit | Korrekt Multiple Choice");
        int[] questionCorrectCount = new int[correctAnswers.length];

        for (Student student : studentsArray) {
            String name = student.getName();
            double average = student.averageGrade();
            int correctCount = student.correctAnswers(correctAnswers);
            for (int i = 0; i < correctAnswers.length; i++) {
                if (student.getStudentMultipleChoice()[i] == correctAnswers[i]) {
                    questionCorrectCount[i]++;
                }

            }
            // Print
            System.out.printf("%-10s %-20.2f %-20d \n", name, average, correctCount);
        }
        // Print for hvert spørgsmål
        System.out.println("\nKorrekte svar for hvert multiple choice svar: ");
        for (int i = 0; i < questionCorrectCount.length; i++) {
            // Dette print fik jeg MEGET hjælp med??? det giver ikke mening, men det virker.
            System.out.printf("Spørgsmål %d %d korrekt\n", i + 1, questionCorrectCount[i]);
        }
    }
}