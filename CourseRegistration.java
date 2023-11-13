import java.util.*;


class Courses {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private int availableSlots;

    public Courses(String code, String title, String description, int capacity) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.availableSlots = capacity;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public boolean isFull() {
        return availableSlots <= 0;
    }

    public void registerStudent() {
        if (!isFull()) {
            availableSlots--;
        }
    }

    public void removeStudent() {
        if (availableSlots < capacity) {
            availableSlots++;
        }
    }

    @Override
    public String toString() {
        return "Course Code: " + code + "\nTitle: " + title + "\nDescription: " + description
                + "\nAvailable Slots: " + availableSlots;
    }
}

class Student {
    private int studentID;
    private String name;
    private List<Courses> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Courses> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerForCourse(Courses course) {
        if (!course.isFull()) {
            registeredCourses.add(course);
            course.registerStudent();
        } else {
            System.out.println("Course " + course.getCode() + " is full. Cannot register.");
        }
    }

    public void removeCourse(Courses course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.removeStudent();
        }
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + "\nName: " + name + "\nRegistered Courses: " + registeredCourses;
    }
}

public class CourseRegistration {
    public static void main(String[] args) {
        Courses mathCourse = new Courses("Math10", "Mathematics 101", "Introductory math course", 20);
        Courses csCourse = new Courses("CS10", "Computer Science 101", "Introductory CS course", 25);

        Student student1 = new Student(1, "Shruti");
        Student student2 = new Student(2, "Tejus");

        student1.registerForCourse(mathCourse);
        student1.registerForCourse(csCourse);
        student2.registerForCourse(mathCourse);

        System.out.println(student1);
		System.out.println("------------------------------") ;
        System.out.println(student2);

        student1.removeCourse(csCourse);
		System.out.println("------------------------------") ;

        System.out.println("After removing CS course:");
		System.out.println("------------------------------") ;
		
        System.out.println(student1);
		System.out.println("------------------------------") ;
        System.out.println(student2);
		
		System.out.println("------------------------------") ;
        System.out.println("Course Details:");
        System.out.println(mathCourse);
        System.out.println(csCourse);
    }
}