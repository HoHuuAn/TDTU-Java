import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentUtils {

    public static List<Student> generate() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Minh", 29, 8, 7.7, 6.5));
        list.add(new Student("Huong", 26, 7.7, 9, 8.1));
        list.add(new Student("Lan", 31, 9, 9.2, 7.0));
        list.add(new Student("Khoa", 24, 8.5, 9, 7.7));
        list.add(new Student("Duy", 18, 7, 6.9, 6.5));
        list.add(new Student("Tu", 29, 6.5, 7.7, 8.4));
        list.add(new Student("Diem", 22, 8, 8.3, 6.9));
        list.add(new Student("Linh", 21, 5, 6.6, 7.7));

        return list;
    }

    public static void print(List<Student> list) {
        System.out.println("\n====================== BEGIN ====================== ");
        list.forEach(System.out::println); // example of Method Reference
        System.out.println("====================== END ====================== \n");
    }

    /**
     * @TODO
     *       Chuy?n �?i c�ch vi?t s? d?ng new Comparator... sang s? d?ng Lambda
     *       Expression
     */
    public static void sortByName(List<Student> list) {
        Collections.sort(list, (o1, o2) -> o1.name.compareTo(o2.name));
    }

    /**
     * @TODO
     *       Chuy?n �?i c�ch vi?t s? d?ng new Comparator... sang s? d?ng Lambda
     *       Expression
     */
    public static void sortByAvg(List<Student> list) {
        Collections.sort(list, (o1, o2) -> {
            if (o1.average() > o2.average())
                return 1;
            if (o1.average() < o2.average())
                return -1;
            return 0;
        });
    }

    /**
     * @TODO
     *       Vi?t ch?c n�ng s?p x?p gi?m d?n theo tu?i s? d?ng lambda expression
     *       G?i ph��ng th?c n�y trong main() �? s?p x?p v� in ra k?t qu?
     */
    public static void sortByAgeDescending(List<Student> list) {
        Collections.sort(list, (o1, o2) -> {
            if (o1.age > o2.age)
                return -1;
            if (o1.age < o2.age)
                return 1;
            return 0;
        });
    }

    /**
     * @TODO
     *       S? d?ng Stream API v� map �? t�nh �i?m trung b?nh c?a to�n b? sinh vi�n
     *       trong danh s�ch
     */
    public static double avg(List<Student> list) {
        Stream<Double> stream = list.stream().map(student -> student.average());
        return stream.reduce(0.0, Double::sum) / list.size();
    }

    /**
     * @TODO
     *       S? d?ng Stream API v� filter, map �? l?y danh s�ch T�N c?a c�c h?c sinh
     *       gi?i
     */
    public static List<String> goodStudentName(List<Student> list) {
        List<String> goodStudents = list.stream()
                                        .filter(student -> student.isGoodStudent())
                                        .map(student -> student.name)
                                        .collect(Collectors.toList());

        return goodStudents;
    }
}
