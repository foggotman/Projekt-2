package model;


import java.util.Random;

public class Student {

    // Field Variables
    private String name;
    private boolean active;
    private int[] studentGrades;
    private char[] studentMultipleChoice = new char[10];

    // Constructor
    public Student(String name, boolean active, int[] studentGrades) {
        this.name = name;
        this.active = active;
        this.studentGrades = studentGrades;

    }

    public char[] getStudentMultipleChoice() {
        return studentMultipleChoice;
    }

    public int[] getStudentGrades() {
        return studentGrades;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public String toString() {
        return name;
    }

    // Metode som tester og opdatere hvis den nye karakter er større
    public double highestGrade() {
        if (studentGrades.length == 0) {
            System.out.println("Ingen karaktere tilgængelig.");
            return 0;
        }
        int highest = studentGrades[0];
        for (int index : studentGrades) {
            if (index > highest) {
                highest = index;
            }
        }
        return highest;
    }

    // Metode som lægger alle karaktere sammen (3) og dividere med antal karakter (3)
    public double averageGrade() {
        int average = 0;
        for (int index : studentGrades) {
            average += index;
        }
        return (double) average / studentGrades.length;
    }

    // Metode til at genere RANDOM answers og convertere det til A B C D, og gemme det i et array.
    public void generateStudentAnswers() {
        Random randomLetters = new Random();
        for (int i = 0; i < studentMultipleChoice.length; i++) {
            int randomNumber = randomLetters.nextInt(4);
            char answer = (char)('A' + randomNumber);
            studentMultipleChoice[i] = answer;
        }
    }
    // Print for feedback
    public void printStudentMultipleChoice() {
        System.out.println("Den studerende's multiple choice: ");
        for (char multipleChoice : studentMultipleChoice) {
            System.out.println(multipleChoice + " ");
        }
        System.out.println();
    }
    // Metode til at tælle antal korrekte svar til hver spørgsmål
    public int correctAnswers(char[] correct) {
        int count = 0;
        for (int i = 0; i < studentMultipleChoice.length; i++) {
            if (studentMultipleChoice[i] == correct[i]) {
                count++;
            }
        }
        return count;
    }
}