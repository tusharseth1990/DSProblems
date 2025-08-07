package interviewQ;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Java8 {


    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Collection<Person> uniquePersons = personList.stream()
                .collect(Collectors.toMap(
                        p -> p.getFirstName() + " " + p.getSecondName() + " " + p.getLastName(), // key
                        p -> p,                 // value
                        (existing, replacement) -> existing // merge function
                ))
                .values();
    }


}
