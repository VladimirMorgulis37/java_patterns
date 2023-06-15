import java.time.LocalDate;
import java.util.*;

public class Application{
    public void stream_test() {
        List<Human> Hum_List = Arrays.asList(
                new Human( 64, "Xi", "Li", LocalDate.of(2003, 7, 28)),
                new Human( 79, "Max", "Johnson", LocalDate.of(1997, 12, 18)),
                new Human( 79, "Troy", "Taker", LocalDate.of(1997, 12, 18)),
                new Human( 79, "Jesse", "Williams", LocalDate.of(1997, 12, 18)),
                new Human( 92, "Peter", "Manson", LocalDate.of(2000, 2, 11)));
        Hum_List.stream().limit(3)
                .filter(x -> x.calculateAge(x.birthDate, x.today) > 20)
                .sorted(Comparator.comparingInt(Human::getNameLength))
                .forEach(System.out::print);
    }

    public static void main(String[] args) {
        Application obj = new Application();
        obj.stream_test();
    }
}
//localdate с текущей датой