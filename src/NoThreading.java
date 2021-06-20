import controllers.PathController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class NoThreading {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("word ?");
        long start = System.currentTimeMillis();
        PathController controller = new PathController("./src/dataset/",s.next());
        System.out.println(controller.getTargetWord() + " appear " + controller.countWordEvidence() + " times");
        System.out.println(System.currentTimeMillis() - start);
    }
}
