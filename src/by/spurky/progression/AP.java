package by.spurky.progression;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class AP {
    public static void main(String[] args) {
        new AP().start();
    }
    private void start() {
        ArithmeticalProgression arithmeticalProgression = new ArithmeticalProgression(1, 5);
        saveToFile(arithmeticalProgression);
//        System.out.println("Delta progression: " + arithmeticalProgression.getDelta());
//        for (int i = 0; i < 30;) {
//            System.out.println(" a[" + (++i) + "] = " + arithmeticalProgression.memberBy(i));
//        }
    }

    public void saveToFile(ArithmeticalProgression ap) {
        File file = new File("ArithmeticalProgression.ap");
        try (FileOutputStream outputStream = new FileOutputStream(file, true)) {
            StringBuilder builder = new StringBuilder();
            builder.append("Арифметическая прогрессия: delta = ")
                    .append(ap.getDelta())
                    .append(", a1 = " + ap.getFirstMember())
                    .append(", a2 = " + ap.getSecondMember())
                    .append("\n");

            int n = 30;
            for (int i = 0; i < n; i++) {
                builder.append("a[" + (i + 1) + "]:" + ap.memberBy((i + 1)) + "\n");
            }

            outputStream.write(builder.toString().getBytes());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
