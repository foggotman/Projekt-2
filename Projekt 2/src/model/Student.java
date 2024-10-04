package model;
import java.util.Random;

public class Student {
    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public int[] getGrades() {
        return grades;
    }

    private String name;
    private boolean active;
    private int[] grades;
    private String[] svarArray;
    private String[] correctAnswers;


    public Student(String name, boolean active, int[] grades) {
        this.name = name;
        this.active = true;
        this.grades = grades;
        this.svarArray = new String[10];
        genererSvar();
    }

    public int getHighestGrade() {
        int højestKarakter = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > højestKarakter) {
                højestKarakter = grades[i];  // Update the highest element with the larger number
            }
        }
        return højestKarakter;
    }

    public double getAverageGrade() {
        double gennemsnitsKarakter = 0;
        for (int i = 0; i < grades.length; i++) {
            gennemsnitsKarakter += grades[i];
        }
        return gennemsnitsKarakter / (grades.length);
    }


    private void genererSvar(){
        Random random = new Random();
        String[] valgMuligheder = {"A", "B", "C", "D"};
        for (int i = 0; i < svarArray.length; i++){
            svarArray[i] = valgMuligheder[random.nextInt(valgMuligheder.length)]; //Assigns a random value to [i] position in svarArray.
        }
    }public String[] getSvarArray() {
        return svarArray;
    }





    }


}
