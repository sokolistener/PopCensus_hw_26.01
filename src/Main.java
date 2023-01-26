import java.util.*;


public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        System.out.println(persons.stream()
                .filter(n -> n.getAge() < 18)
                .count());

        List<String> mobPersons = persons.stream()
                .filter(n -> n.getAge() >= 18)
                .filter(n -> n.getAge() <= 27)
                .filter(n -> n.getSex() == Sex.MAN)
                .map(n -> n.getFamily())
                .toList();
//        System.out.println(mobPersons.size());


        List<Person> highPersons = persons.stream()
                .filter(n -> n.getEducation() == Education.HIGHER)
                .filter(n -> n.getAge() >= 18)
                .filter(n -> n.getSex() == Sex.MAN ? n.getAge() <= 65 : n.getAge() <= 60)
                .sorted(Comparator. comparing(Person::getFamily))
                .toList();

//        System.out.println(highPersons.size());

    }
}