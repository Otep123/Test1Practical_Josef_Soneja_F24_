import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The main application class that manages courses.
 */
public class App {

    List<Course> courses; // List to store courses
    Scanner sc; // Scanner for user input

    /**
     * Initializes the application with a sample course and a scanner.
     */
    App() {
        sc = new Scanner(System.in);
        courses = new ArrayList<>();
        courses.add(new Course("Otep", "Otep", "Otep", 123));
    }

    /**
     * Starts the application and presents the user with a menu to interact with.
     */
    public void start() {
        while (true) {
            Util.print(TextUI.menu);
            switch(sc.nextLine()) {
                case "1":
                    Course course = Util.promptCourse(sc);
                    addCourse(courses, course);
                    break;
                case "2":
                    Util.print(TextUI.printList(courses));
                    Util.print(TextUI.askIndex);
                    int index = Util.promptNumber(sc) - 1;
                    if (index >= 0 && index < courses.size()) {
                        Course courseToBeEdited = courses.get(index);
                        editCourse(courses, courseToBeEdited);
                    } else Util.print(TextUI.invalidOption());
                    break;
                case "3":
                    Util.print(TextUI.printList(courses));
                    break;
                default:
                    Util.print(TextUI.invalidOption());
            }
        }
    }

    /**
     * Edits the specified course based on user input.
     *
     * @param courses the list of courses
     * @param courseToBeEdited the course to be edited
     */
    private void editCourse(List<Course> courses, Course courseToBeEdited) {
        while (true) {
            Util.print(TextUI.menuEdit);
            switch(Util.promptNumber(sc)) {
                case 1:
                    String name = Util.promptCourseName(sc);
                    courseToBeEdited.setName(name);
                    break;
                case 2:
                    String code = Util.promptCourseCode(sc);
                    courseToBeEdited.setCode(code);
                    break;
                case 3:
                    String date = Util.promptCourseDate(sc);
                    courseToBeEdited.setStartDate(date);
                    break;
                case 4:
                    int numOfStudents = Util.promptCourseNumberOfStudents(sc);
                    courseToBeEdited.setNumberOfStudents(numOfStudents);
                    break;
                case 5:
                    courses.remove(courseToBeEdited);
                    courses.add(courseToBeEdited);
                    return;
                default:
                    Util.print(TextUI.invalidOption());
            }
        }
    }

    /**
     * Adds a new course to the list of courses.
     *
     * @param courses the list of courses
     * @param course the course to be added
     */
    private void addCourse(List<Course> courses, Course course) {
        courses.add(course);
    }
}

/**
 * A utility class for managing text user interfaces and messages.
 */
class TextUI {
    public static String menu = """
            ------------------------
            
                1. Add a Course
            
                2. Edit a course
            
                3. List courses
            
                Enter a choice:
            
            ------------------------- 
            """.trim();

    public static String menuEdit = """
            ------------------------
            
                1. Course Name
            
                2. Course Code
            
                3. Course Date
            
                4. Course Student Count
            
                5. Quit
            
                Enter a choice:
            
            ------------------------- 
            """.trim();

    public static String askCourseName = "What is the name of the course?\n";
    public static String askCourseCode = "What is the code of the course?\n";
    public static String askCourseDate = "What is the date of the course?\n";
    public static String askCourseNumberOfStudents = "What is the number of students?\n";
    public static String askIndex = "What is the index of the course from the list?\n";

    /**
     * Returns an invalid option message.
     *
     * @return a string indicating an invalid option
     */
    public static String invalidOption() {
        return "The chosen option is invalid!";
    }

    /**
     * Prints the items in the given list.
     *
     * @param list the list of items to print
     * @param <T> the type of the items in the list
     * @return a formatted string of the list items
     */
    public static <T> String printList(List<T> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("Items in list:\n");
        for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
            sb.append(String.format("%d. %s", i+1, o.toString())).append('\n');
        }
        return sb.toString();
    }
}

/**
 * A utility class that provides methods for user input and output.
 */
class Util {
    /**
     * Prints the specified string to the console.
     *
     * @param string the string to print
     */
    public static void print(String string) {
        System.out.println(string);
    }

    /**
     * Prompts the user for course details and creates a Course object.
     *
     * @param input the Scanner object for user input
     * @return a new Course object with user-defined details
     */
    public static Course promptCourse(Scanner input) {
        String name = promptCourseName(input);
        String code = promptCourseCode(input);
        String date = promptCourseDate(input);
        int numberOfStudents = promptCourseNumberOfStudents(input);

        return new Course(name, code, date, numberOfStudents);
    }

    public static String promptCourseName(Scanner input) {
        print(TextUI.askCourseName);
        return input.nextLine();
    }

    public static String promptCourseCode(Scanner input) {
        print(TextUI.askCourseCode);
        return input.nextLine();
    }

    public static String promptCourseDate(Scanner input) {
        print(TextUI.askCourseDate);
        return input.nextLine();
    }

    /**
     * Prompts the user for the number of students and handles invalid input.
     *
     * @param input the Scanner object for user input
     * @return the number of students as an integer
     */
    public static int promptCourseNumberOfStudents(Scanner input) {
        print(TextUI.askCourseNumberOfStudents);

        while (true) {
            try {
                return Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                print(TextUI.invalidOption());
            }
        }
    }

    /**
     * Prompts the user for a number and handles invalid input.
     *
     * @param sc the Scanner object for user input
     * @return the input number as an integer
     */
    public static int promptNumber(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                print(TextUI.invalidOption());
            }
        }
    }
}
