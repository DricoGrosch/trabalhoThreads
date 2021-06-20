import controllers.PathController;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Threading {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger counter = new AtomicInteger();
        Scanner s = new Scanner(System.in);
        System.out.println("word ?");
        PathController controller = new PathController("./src/dataset/", s.next());
        long start = System.currentTimeMillis();
        int pathLength = controller.getFiles().length;
        Thread t1 = new Thread(() -> {
            try {
                int a = controller.countWordEvidence(0, pathLength / 2);
                counter.addAndGet(a);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                int a = controller.countWordEvidence((pathLength / 2), pathLength);
                counter.addAndGet(a);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(controller.getTargetWord() + " appear " + counter + " times");
        System.out.println(System.currentTimeMillis() - start);

    }
}
