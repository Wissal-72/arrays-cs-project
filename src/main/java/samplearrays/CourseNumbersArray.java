package samplearrays;

public class CourseNumbersArray {
    private static int[] updatedCourses = new int[0];
    public static void addCourse(int course){
        if(updatedCourses.length == 0) {
            updatedCourses = new int[1];
            updatedCourses[0]= course;
            return;
        }
        int[] registered = new int[updatedCourses.length +1];
        for( int i = 0 ; i< updatedCourses.length ; i++){
            registered[i] = updatedCourses[i];
        }
        registered[updatedCourses.length] = course;

        updatedCourses = registered;

    }
    public static  void display(){
        System.out .println("All registered courses : ");
        for (int course : updatedCourses){
            System.out.println(". "+ course);
        }
    }
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        for (int course : registeredCourses){
            addCourse(course);
        }

        addCourse(5555);

        display();

        System.out.println("Total : "+ updatedCourses.length + " courses");

    }
}
