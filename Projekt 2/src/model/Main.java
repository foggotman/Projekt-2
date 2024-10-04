package model;

public class Main {
    public static void main(String[] args) {


        Student student1 = new Student("Dean", true, new int[]{7, 10, 12});
        Student student2 = new Student("Mauer", true, new int[]{7, 4, 4});
        Student student3 = new Student("Ole", true, new int[]{2, 4, 0});
        Student student4 = new Student("Fede", true, new int[]{12, 10, 12});
        Student student5 = new Student("Hank", true, new int[]{12, 2, 0});
        Student student6 = new Student("Honk", true, new int[]{10, 4, 12});

        Team team1 = new Team("Team 1", "BioFysik");
        team1.addStudent(student1);
        team1.addStudent(student2);
        team1.addStudent(student3);

        Team team2 = new Team("Team 2", "Musik");
        team2.addStudent(student4);
        team2.addStudent(student5);
        team2.addStudent(student6);
        team2.removeStudents("Hank");

        System.out.println("Studerende på " + team1.getName());
        for (int i = 0; i < team1.getAllStudents().length; i++) {
            Student studentTeam1 = team1.getAllStudents()[i];
            System.out.println(studentTeam1.getName());
        }

        System.out.println();

        System.out.println("Studerende på " + team2.getName());
        for (int i = 0; i < team2.getAllStudents().length; i++) {
            Student studentTeam2 = team2.getAllStudents()[i];
            System.out.println(studentTeam2.getName());
        }

        System.out.println();

        System.out.println(student1.getName() + "s Højeste karakter: " + student1.getHighestGrade());
        System.out.println(student1.getName() + "s Gennemsnitskarakter: " + student1.getAverageGrade());

        System.out.println(team1.getName() + "s Gennemsnitskarakter" + team1.getAverageGrades());


        Student[] topStudents1 = team1.highScoreStudents(5);
        System.out.println("\nBedste studenter i " + team1.getName());
        for (int i = 0; i < topStudents1.length; i++) {

            System.out.println(topStudents1[i].getName());

            System.out.println();

            System.out.println();

            Student[] studenterRettes = team1.getAllStudents();

            for (int k = 0; k < studenterRettes.length; k++) {
                Student student = studenterRettes[k];
                System.out.println(student.getName() + "s svar på testen");

                String[] svar = student.getSvarArray();
                for (int j = 0; j < svar.length; j++) {
                    System.out.println(svar[j] + " ");
                }
                System.out.println();


            }

        }


    }
}
