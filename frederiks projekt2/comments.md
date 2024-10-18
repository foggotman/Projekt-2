generateStudentAnswers kan med fordel kaldes fra constructoren, så I er sikker
 på at få genereret de tilfældige svar.

---

Jeg synes ikke at kunne finde en metode der dækker opgave 1.4, overså I denne opgave?

---

I averageGrade metoden dividerer I med 3, men det er ikke sikkert at 
den studerende har 3 karakterer. I stedet skal I dividerer med længden af studentGrades.
Se min ændring. 

---

I metoden beståetStuderende i Team klassen beregner I den gennemsnitlige karakter for hver studerende. 

                int[] grades = student.getStudentGrades();
                double total = 0;
                for (int grade : grades) {
                    total += grade;
                }
                double average = 0;
                if (grades.length >= 0) {
                    average = total / grades.length;
                }

men I har allerede en averageGrade metode på den studerende, så brug den i stedet

                double average = student.averageGrade();

---

