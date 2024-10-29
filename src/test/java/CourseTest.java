import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    @Test
    void testEquals() {
        Course course1 = new Course("Otep", "Otep", "2024", 123);
        Course course2 = new Course("Otep", "Otep", "2024", 123);

        assert course1.equals(course2);
    }

    @Test
    void testNotEquals() {
        Course course0 = new Course("Otep", "Brotep", "2024", 123);
        Course course1 = new Course("Otep", "otep", "2024", 123);
        Course course2 = new Course("Otep", "Otep", "2024", 123);

        assert !course1.equals(course2);
        assert !course0.equals(course2);
        assert !course1.equals(course0);
    }
}