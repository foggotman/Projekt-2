package test;

import model.Student;
import model.Team;
import model.Horde;

import java.util.Scanner;

public class App3a {
    public static void main(String[] args) {
        // Scanners
        Scanner scanner = new Scanner(System.in);

        // Gruppe af teams
        Horde horde = new Horde();

        System.out.println("Vil du oprette et team? Ja/Nej");
        String answer = scanner.nextLine();
        if (answer.equals( "Nej")) {
            System.out.println("Intet team er oprettet.");
        } else {
            System.out.println("Hvor mange teams vil du lave?");
            int hordes = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < hordes; i++) {
                System.out.println("Indtast navnet på team: " + (i + 1));
                String teamName = scanner.nextLine();

                System.out.println("Indtast navnet på lokalet.");
                String roomName = scanner.nextLine();

                Team team = new Team(teamName, roomName);

                System.out.println("Hvor mange studerende vil du oprette til teamet?");
                int teamSize = scanner.nextInt();
                scanner.nextLine();

                for (int k = 0; k < teamSize; k++) {
                    System.out.println("\nIndtast den studerendes information " + (k + 1) + " : ");

                    System.out.println("Indtast elevens navn: ");
                    String name = scanner.nextLine();
                    scanner.nextLine();

                    System.out.println("Indtast om eleven er aktiv: true/false");
                    boolean active = scanner.nextBoolean();

                    int[] studentGrades = new int[3];
                    System.out.println("Indtast 3 karaktere for eleven: ");
                    for (int j = 0; j < 3; j++) {
                        System.out.println("Karakter " + (j + 1) + ": ");
                        studentGrades[j] = scanner.nextInt();
                    }
                    scanner.nextLine();

                    Student student = new Student(name, active, studentGrades);

                    team.addStudent(student);
                }
                horde.addHorde(team);
            }
            System.out.println("Vil du udskrive gennemsnits karakteren for eleverne? Ja/Nej");
            String answer2 = scanner.nextLine();
            if (answer2.equals("Ja")) {
                for (Team team : horde.getHorde()) {
                    System.out.println("Faction: " + team.getName());
                    for (Student student : team.getStudentsArray()) {
                        System.out.println("Studerende: " + student.getName() + " - Gennemsnitskarakter: " + student.averageGrade());
                    }
                }
            }
            scanner.close();
        }
    }
}