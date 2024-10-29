/**
 * Represents a course with details such as name, code, start date,
 * number of students enrolled, and a count for internal use.
 */
public class Course {
    // INSTANCE VARIABLES - private attributes only the class can see
    private String name;
    private String code;
    private String startDate;
    private int numberOfStudents;
    private static int count;

    /**
     * Constructs a Course with specified details.
     *
     * @param name             the name of the course
     * @param code             the code of the course
     * @param startDate        the start date of the course
     * @param numberOfStudents the number of students enrolled in the course
     */
    public Course(String name, String code, String startDate, int numberOfStudents) {
        this.name = name;
        this.code = code;
        this.startDate = startDate;
        this.numberOfStudents = numberOfStudents;
        Course.count++;
    }

    /**
     * Constructs a Course with default values.
     * Name, code, and start date are set to "N/A", and number of students and count are set to 0.
     */
    public Course() {
        this.name = "N/A";
        this.code = "N/A";
        this.startDate = "N/A";
        this.numberOfStudents = 0;
        Course.count++;
    }

    /**
     * Returns the name of the course.
     *
     * @return the name of the course
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the course.
     *
     * @param name the name to set for the course
     */
    public void setName(String name) {
        // 'name' here is a parameter
        this.name = name;
    }

    /**
     * Returns the code of the course.
     *
     * @return the code of the course
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the code of the course.
     *
     * @param code the code to set for the course
     */
    public void setCode(String code) {
        // 'code' here is a parameter
        this.code = code;
    }

    /**
     * Returns the start date of the course.
     *
     * @return the start date of the course
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date of the course.
     *
     * @param startDate the start date to set for the course
     */
    public void setStartDate(String startDate) {
        // 'startDate' here is a parameter
        this.startDate = startDate;
    }

    /**
     * Returns the number of students enrolled in the course.
     *
     * @return the number of students
     */
    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    /**
     * Sets the number of students enrolled in the course.
     *
     * @param numberOfStudents the number of students to set
     */
    public void setNumberOfStudents(int numberOfStudents) {
        // 'numberOfStudents' here is a parameter
        this.numberOfStudents = numberOfStudents;
    }

    /**
     * Returns the internal count for the course.
     *
     * @return the internal count
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets the internal count for the course.
     *
     * @param count the count to set
     */
    public void setCount(int count) {
        // 'count' here is a parameter
        this.count = count;
    }

    /**
     * Returns a string representation of the course.
     *
     * @return a string in the format "[code, name]"
     */
    @Override
    public String toString() {
        return String.format("[%s, %s]", this.getCode(), this.getName());
    }

    /**
     * Compares this course with another object for equality.
     *
     * @param obj the object to compare with
     * @return true if the object is a Course with the same code; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Course c) {
            // LOCAL VARIABLE - 'c' is a local variable, only seen within this scope
            return this.getCode().equals(c.getCode());
        }
        return false;
    }
}
