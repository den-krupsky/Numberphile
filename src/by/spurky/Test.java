package by.spurky;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        new Test().start();
    }

    private void start() {
        final Integer BOUND = 9;

        Stream<Integer> stream = Stream.iterate(1, (n) -> n + 1);
        List<Integer> list = stream.limit(BOUND).collect(Collectors.toList());
        


        for (int i = 2; list.size() != 1; i++){
            System.out.print("{ ");
            list = acceptTimes(i, list.stream());
            System.out.print("}");
            System.out.println(" : sum("+ list.stream().reduce((x, acc) -> acc + x).get() + ")");
        }
    }

    public List<Integer> acceptTimes(final Integer t, Stream<Integer> stream) {
        return stream.filter((x) -> x % t != 0).peek((v) -> System.out.print(v + " ")).collect(Collectors.toList());
    }

 }

