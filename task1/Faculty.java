package lab9.task1;

import java.util.*;

public class Faculty {
    private String name;
    private String address;
    private List<Course> courses;

    public Faculty(String name, String address, List<Course> courses) {
        this.name = name;
        this.address = address;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    //Câu 1
    public Course getMaxPracticalCourse() {
        Course result = null;
        int max = 0;
        for (Course course : courses) {
            if (course.getType().equals("Practical") && course.getStudents().size() >= max) {
                max = course.getStudents().size();
                result = course;
            }
        }
        return result;
    }

    //Câu 2
    public Map<Integer, List<Student>> groupStudentsByYear() {
        Map<Integer, List<Student>> result = new HashMap<>();
        for (Course course : courses) {
            Set<Map.Entry<Integer, List<Student>>> set = course.groupStudentsByYear().entrySet();
            for (Map.Entry<Integer, List<Student>> ele : set) {
                if (result.containsKey(ele.getKey())) {
                    result.get(ele.getKey()).addAll(ele.getValue());
                } else {
                    result.put(ele.getKey(), ele.getValue());
                }
            }
        }
        return result;
    }

    //Câu 3
    public Set<Course> filterCourses(String type) {
        Set<Course> result = new TreeSet<>(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.getStudents().size() - o2.getStudents().size();
            }
        });

        for (Course course : courses) {
            if (course.getType().equals(type)) result.add(course);
        }

        return result;
    }

    public static void main(String[] args) {
        Student s1 = new Student(null, null, 2022);
        Student s2 = new Student(null, null, 2021);
        Student s3 = new Student(null, null, 2021);
        Student s4 = new Student(null, null, 2021);
        Student s5 = new Student(null, null, 2023);

        List<Student> ls1 = new ArrayList<>();
        ls1.add(s1);
        ls1.add(s2);
        List<Student> ls2 = new ArrayList<>();
        ls2.add(s3);
        ls2.add(s4);
        ls2.add(s5);

        Course c1 = new Course(null, null, null, ls1, null);
        Course c2 = new Course(null, null, null, ls2, null);
        List<Course> lc = new ArrayList<>();
        lc.add(c1); lc.add(c2);

        Faculty f = new Faculty(null, null, lc);

        System.out.println(f.groupStudentsByYear());
    }
}
