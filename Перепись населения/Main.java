import java.util.*;
import java.util.stream.*;

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



        long count = persons.stream()
                .filter(x -> x.getAge() < 18)
                .count();

        System.out.println("Несовершеннолетних: " + count);


        List<String> conscripts = persons.stream()
                .filter(x -> x.getAge() >= 18 && x.getAge()<= 27 )
                .map(Person::getFamily)
                .collect(Collectors.toList());


        System.out.println("Список военнообязанных: " + Arrays.toString(conscripts.toArray()));

        List<Person> workers = persons.stream()
                .filter(x -> x.getEducation() == Education.HIGHER)
                .filter(x -> x.getAge() >= 18 )
                .filter(x -> x.getSex() == Sex.MAN && x.getAge() <= 65 || x.getSex() == Sex.WOMAN && x.getAge() <= 60)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());

        System.out.println("Список работников: " + Arrays.toString(workers.toArray()));
    }
}





enum Sex {
    MAN,
    WOMAN
}




    enum   Education {
        ELEMENTARY,
        SECONDARY,
        FURTHER,
        HIGHER
    }



class Person{
    private String name;
    private String family;
    private Integer age;
    private Sex sex;
    private Education education;

    public Person(String name, String family, int age, Sex sex, Education education) {
        this.name = name;
        this.family = family;
        this.age = age;
        this.sex = sex;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Education getEducation() {
        return education;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", education=" + education +
                '}';
    }
}

