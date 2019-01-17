package by.spurky;

public class Main {

    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {
        int source = 9; //исходное число
        int sourceCounter = source; //количество оставшихся чисел от исходного
        int sumSource = 0;

        for (int i = 1; i <= source; i = i + 1) { // 0 step
            sumSource += i;
        }
        System.out.println(format(source, sourceCounter, sumSource));

        sourceCounter--;
        sumSource = 0;
        for (int i = 1; i <= source; i = i + 1) { // 1 step
            sumSource +=i;
        }
        sumSource = sumSource - 1;
        System.out.println(format(source, sourceCounter, sumSource));

        sourceCounter--;
        sumSource = 0;
        for (int i = 1; i <= source; i = i + 1) { // 2 step
            sumSource +=i;
        }
        sumSource = sumSource - 1 - f(Math.round(sourceCounter / 2f), 2);
        System.out.println(format(source, sourceCounter, sumSource));

        sourceCounter--;
        sumSource = 0;
        for (int i = 1; i <= source; i = i + 1) { // 3 step
            sumSource +=i;
        }
        sumSource = sumSource - 1 - f(Math.round(sourceCounter / 2f), 2);
        System.out.println(format(source, sourceCounter, sumSource));



    }

    public Integer f(Integer times, Integer n){
        int sum = 0;
        for (int i = 1; i <= times ; i++) {
            sum += n * i;
        }
        return sum;
    }

    public String format(Integer source, Integer sourceCounter, Integer sumSource) {
        return String.format("Source = %d, counter = %d, sum = %d", source, sourceCounter, sumSource);
    }



}
