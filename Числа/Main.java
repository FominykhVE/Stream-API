import java.util.*;
import java.util.stream.*;



public class Main {

    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

        Stream<Integer> stream = intList.stream()
                .filter(x -> x > 0)
                .filter(x -> x % 2 == 0 )
                .sorted(Comparator.naturalOrder());
        stream.forEach(System.out::println);

    }


}

class StreamMain{

    public static void main(String[] args){

        List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4));

        Collections.sort(intList);


        for (int i = 0; i < intList.size(); i++){

            if( intList.get(i) <= 0){
                intList.remove(i);
            }

            if(intList.get(i) % 2 != 0){
                intList.remove(i);
            }
        }




        System.out.println(Arrays.toString(intList.toArray()));


    }

}