import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
public class Human {
    int age, weight;
    String firstName, lastName;
     LocalDate birthDate;
     LocalDate today = LocalDate.now();
    LocalDate birthday = LocalDate.of(1960, Month.JANUARY, 1);

    Human (int weight, String firstName, String lastName, LocalDate birthDate) {
        this.age = age;
        this.weight = weight;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
    int getNameLength(){
        return firstName.length();
    }
    @Override
    public String toString() {
        return firstName + " ";
    }
    int calculateAge(LocalDate birthDate, LocalDate currentDate) {
            return Period.between(birthDate, currentDate).getYears();
        }
}
