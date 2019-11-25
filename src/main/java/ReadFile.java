import java.util.*;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.nio.file.Files;


public class ReadFile {

    private Path file;
    private List<String> l;
    private int first;
    private String[] array;
    private Map<String, String> map;

    public ReadFile() {

    }

    public boolean setFile(String fileName) {
        try {
            file = new File(getClass().getResource(fileName).getFile()).toPath();
            firstLines();
            parseFile();
            return true;
        } catch (NullPointerException e) {
            System.out.println("Enter the correct file name");
        }
        return false;
    }

    public void firstLines() {
        try (Stream<String> stream = Files.lines(file)) {
            array = stream.limit(2)
                    .toArray(String[]::new);

            first = Integer.parseInt(array[0]);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void parseFile() {


        try (Stream<String> stream = Files.lines(file)) {
            map = stream.skip(2)

                    .collect(Collectors.toMap(s -> s.split(" ")[0], a -> a.substring(a.split(" ")[0].length() + 1)));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void bestDecade() {
        for (String name : map.keySet()) {


            String[] arr = map.get(name).split(" ");
            int temp = -1;
            int[] v = Stream.of(arr)

                    .mapToInt(Integer::parseInt)
                    .toArray();

            int min = Arrays.stream(v)
                    .filter(num -> num != 0)
                    .min()
                    .getAsInt();

            for (int i = 0; i < v.length; i++) {

                if (v[i] == min)
                    temp = i;
            }


            temp = temp * 10 + first;
            System.out.println(name + " best decade was " + temp);


        }
    }

    public void numOfDecades() {

        for (String name : map.keySet()) {


            String[] arr = map.get(name).split(" ");

            long count = Stream.of(arr)

                    .mapToInt(Integer::parseInt)
                    .filter(a -> a != 0)
                    .count();


            System.out.println(name + " was " + count + " in top 1000.");
        }
    }

    public void increasing() {

        for (String name : map.keySet()) {


            String[] arr = map.get(name).split(" ");
            boolean check = true;
            int[] v = Stream.of(arr)

                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int i = 1; i < v.length; i++) {

                if (v[i] <= v[i - 1])
                    check = false;
            }
            System.out.println(name + " was strictly increasing " + check);
        }
    }

    public void decreasing() {

        for (String name : map.keySet()) {


            String[] arr = map.get(name).split(" ");
            boolean check = true;
            int[] v = Stream.of(arr)

                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int i = 1; i < v.length; i++) {

                if (v[i] >= v[i - 1])
                    check = false;
            }
            System.out.println(name + " was strictly decreasing " + check);
        }


    }

    public void popularity(int decade) {

        int number = (decade - first) / 10;

        PriorityQueue<Name> pq = new PriorityQueue<Name>(new NameComparator());
        int num = 0;
        for (String key : map.keySet()) {

            String test2 = map.get(key);
            String[] test = map.get(key).split(" ");
            try {
                num = Integer.parseInt(test[number]);
            } catch (ArrayIndexOutOfBoundsException e) {
                num = 0;
            }
            if (num != 0)
                num = 1001 - num;
            else
                num = 1;
            pq.add(new Name(key, num));

        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll().getName());

        }

    }
}



