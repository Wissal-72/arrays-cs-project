package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        Student oldest = students[0];
        for(Student stdnt: students){
            if(stdnt.getAge()> oldest.getAge()) oldest = stdnt;
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count = 0;
        for(Student stdnt : students){
            if(stdnt.getAge()>=18) count++;
        }
        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        double sum = 0;
        for(Student stdnt: students){
            sum+= stdnt.getGrade();
        }
        return sum/students.length;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for(Student stdnt : students){
            if (stdnt.getName().equals(name)) return stdnt;
        }

        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        Arrays.sort(students , (Student s1, Student s2) -> s2.getGrade()- s1.getGrade());
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for(Student stdnt: students){
            if(stdnt.getGrade()>=15) System.out.println(stdnt.getName());
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for(Student stdnt : students){
            if(stdnt.getId() == id) {
                stdnt.setGrade(newGrade);
                return true;
            }
        }
        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        int cnt = 0;
        for(int i = 0; i< students.length; i++){
            for (int j = i+1 ; j< students.length; j++ ){
                if(students[i].getName().equals(students[j].getName())) cnt++;
            }
        }
        if(cnt>0){
            System.out.println("Duplicates found !");
            return true;
        }
        System.out.println("No duplicates found");
        return  false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] updatedStudents = new Student[students.length +1];
        for (int i =0 ; i< students.length ; i++){
            updatedStudents[i]= students[i];
        }
        updatedStudents[students.length] = newStudent;

        return updatedStudents;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] students  = {
                new Student(1, "Joe", 18 , 15 ),
                new Student(2, "Alex", 19 , 13),
                new Student(3 , "Jamie", 17, 17),
                new Student(4 , "Sam", 19 , 16),
                new Student(5 , "Nick", 17 , 12)
        };


        // Print all
        System.out.println("== All Students ==");
        for (Student s : students) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println("The eldest student is  : "+findOldest(students));

        // 3) Count adults
        System.out.println("There are "+ countAdults(students)+ " adult students");

        // 4) Average grade
        System.out.println("The average grade is : "+ averageGrade(students));

        // 5) Find by name
        System.out.println("Finding Alex : ");
        findStudentByName(students,"Alex") ;


        // 6) Sort by grade desc
        sortByGradeDesc(students);

        // sort function
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : students) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(students);

        // 8) Update grade by i
        if (updateGrade(students,4, 11)){
            System.out.println("\nUpdated id=4? " + students[3].getGrade());
        }
        // function

        System.out.println(findStudentByName(students, "Dina"));

        // 9) Duplicate names
        boolean hasDups = hasDuplicateNames(students);

        // 10) Append new student
        students = appendStudent(students , new Student(6 , "Lisa"));
    }
}

