package test;

import model.Student;
import model.Team;

import java.util.Arrays;


public class App {
    public static void main(String[] args) {
        // Student Objekter
        Student student = new Student("Mads", true, new int[]{10, 7, 4});
        Student student1 = new Student("Mikkel", true, new int[]{4, 12, 7});
        Student student2 = new Student("Andreas", true, new int[]{4, 4, 0});
        Student student3 = new Student("Anders", true, new int[]{7, 7, 7});
        Student student4 = new Student("Kristoffer", true, new int[]{10, 12, 12});
        Student student5 = new Student("Karl Ejner", true, new int[]{2, 4, 0});

        // Team Objekter
        Team team = new Team("Turbo Teamet", "Rum 1");
        Team team1 = new Team("Chill Team", "Rum 2");

        // Students added til team Turbo Teamet
        team.addStudent(student);
        team.addStudent(student1);
        team.addStudent(student2);
        // Students added til team Chill Teamet
        team1.addStudent(student3);
        team1.addStudent(student4);
        team1.addStudent(student5);

        System.out.println("Turbo Teamet: ");
        // Kalder print metode i Team
        team.printStudents();
        System.out.println("Chill Teamet: ");
        // Kalder print metode i Team
        team1.printStudents();

        // Kalder removeStudent metode i Team, dette kommer til at påvirke senere prints.
        team.removeStudent("Mads");
        team1.removeStudent("Karl Ejner");

        // Tester om students blev fjernet fra team
        System.out.println("Turbo Teamet: ");
        team.printStudents();
        System.out.println("Chill Teamet: ");
        team1.printStudents();

        // Højeste Krakter Print
        System.out.println(student.getName() + "'s højeste karakter: " + student.highestGrade());
        System.out.println(student1.getName() + "'s højeste karakter: " + student1.highestGrade());
        System.out.println(student2.getName() + "'s højeste karakter: " + student2.highestGrade());
        System.out.println(student3.getName() + "'s højeste karakter: " + student3.highestGrade());
        System.out.println(student4.getName() + "'s højeste karakter: " + student4.highestGrade());
        System.out.println(student5.getName() + "'s højeste karakter: " + student5.highestGrade());

        // Gennemsnits Karakter Print
        System.out.println(student.getName() + "'s gennemsnits karakter: " + student.averageGrade());
        System.out.println(student1.getName() + "'s gennemsnits karakter: " + student1.averageGrade());
        System.out.println(student2.getName() + "'s gennemsnits karakter: " + student2.averageGrade());
        System.out.println(student3.getName() + "'s gennemsnits karakter: " + student3.averageGrade());
        System.out.println(student4.getName() + "'s gennemsnits karakter: " + student4.averageGrade());
        System.out.println(student5.getName() + "'s gennemsnits karakter: " + student5.averageGrade());

        // Gennemsnits Karakter for team Print
        System.out.println("Turbo Teamet's gennemsnitskarakter: " + team.teamAverage());
        System.out.println("Chill Teamet's gennemsnitskarakter: " + team1.teamAverage());

        // Tester om students "bestod"
        System.out.println("Elever som bestod minimum average 7.0: " + Arrays.toString(team.beståetStuderende(7.0)));
        System.out.println("Elever som bestod minimum average 2.0: " + Arrays.toString(team.beståetStuderende(2.0)));

        // Parameter til at sende videre til metoder
        char[] correctInput = {'A', 'B', 'C', 'D', 'A', 'C', 'B', 'D', 'A', 'C'};
        System.out.println("De korekte svar på multiple choice er: 'A', 'B', 'C', 'D', 'A', 'C', 'B', 'D', 'A', 'C'");

        // Tester om metoder virker for 3 studerende
        student.generateStudentAnswers();
        student1.generateStudentAnswers();
        student2.generateStudentAnswers();
        student.printStudentMultipleChoice();

        // Tester om metoden virker for teamet
        team.printTeamAnswers();

        // Tester om correctCount tæller op for hver individuelle spørgsmål, og gemmer det i et array
        int correctCount = student.correctAnswers(correctInput);
        int teamCorrectCount = team.countTeamCorrectAnswers(correctInput);
        System.out.println("Antal korrekte for studerende: " + correctCount);
        System.out.println("Antal korrekte for teamet: " + teamCorrectCount);
        System.out.println(); // Next Line

        // Metode til at printe i kolonner
        team.printStatistics(correctInput);
    }
}