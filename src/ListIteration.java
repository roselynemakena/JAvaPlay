import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;
import java.util.stream.Stream;

public class ListIteration {

    static List<String> countries = Arrays.asList(
            "Kenya",
            "Philipinnes",
            "Mexico",
            "Tanzania",
            "India"
    );

    public static void main(String args[]) {
        usingLoops();
        usingListIterator();
        iteratebyConvertingStringToArray();
        printContentsByConvertingToString();
        usingEnumerationInterface();
    }

    public static void usingLoops(){
        //1 - using enhanced loop
        System.out.println("1 - using enhanced loop");
        for (String country : countries) {
            System.out.println(country);
        }

        //2 - using standard loop
        System.out.println("2 - using standard loop");
        for (int i = 0; i < countries.size(); i++) {
            System.out.println(countries.get(i));
        }
    }

    public static  void usingListIterator() {
        //3 - Using list iterator
        System.out.println("3 - Using list iterator");
        ListIterator<String> listIterator = countries.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        //4 - Using iterator
        System.out.println("4 - Using iterator");
        Iterator iterator = countries.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void iteratebyConvertingStringToArray() {

        String[] countriesArray = null;
        System.out.println("5 - By converting to String - list.toArray([])");
        countriesArray = countries.toArray(new String[countries.size()]);
        System.out.println(Arrays.toString(countriesArray));

        System.out.println("6 - By converting to String - list.toArray([]) - no memory");
        countriesArray = countries.toArray(new String[0]);
        System.out.println(Arrays.toString(countriesArray));

        System.out.println("7 - By converting to String - list.toArray()");
        System.out.println(Arrays.toString(countriesArray));

        System.out.println("8 - By converting to String - using streams - lambda");
        countriesArray = countries.stream().toArray(String[]::new);
        System.out.println(Arrays.toString(countriesArray));

        System.out.println("9 - By converting to String - using streams - method references");
        countriesArray = countries.stream().toArray(n -> new String[n]);
        System.out.println(Arrays.toString(countriesArray));
    }

    public static void printContentsByConvertingToString() {
        System.out.println("10 - By converting to String < Java 8");
        System.out.println(countries.toString());

        System.out.println("11 - By converting to String => Java 8");
        Stream.of(countries.toString()).forEach(
                System.out::println);
    }

    public static void usingEnumerationInterface() {
        //To Vector
        Enumeration<String> enumeration = new Vector(countries).elements();
        System.out.println("12 - By converting to Enumeration");

        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }

        System.out.println("13 - By using Enumeration.Collections");
        enumeration = Collections.enumeration(countries);

        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }

    }

}
