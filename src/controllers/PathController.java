package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class PathController implements Runnable {
    String path;
    File folder;
    String targetWord;

    public PathController(String path, String targetWord) {
        this.path = path;
        this.folder = new File(path);
        this.targetWord = targetWord;
    }

    public String getTargetWord() {
        return targetWord;
    }

    public int countWordEvidence() throws IOException {
        int counter = 0;
        File[] files = this.getFiles();
        for (File file : files) {
            if (file.isFile()) {
                BufferedReader abc = new BufferedReader(new FileReader(this.path + file.getName()));
                String line;
                while ((line = abc.readLine()) != null) {
                    if (line.equals(this.targetWord)) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public int countWordEvidence(int start, int end) throws IOException {
        int counter = 0;
        File[] files = this.getFiles();
        File[] slices = Arrays.copyOfRange(files, start, end);
        for (File file : slices) {
            if (file.isFile()) {
                BufferedReader abc = new BufferedReader(new FileReader(this.path + file.getName()));
                String line;
                while ((line = abc.readLine()) != null) {
                    if (line.equals(this.targetWord)) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public String getPath() {
        return this.path;
    }

    public File[] getFiles() {
        return this.folder.listFiles();
    }

    @Override
    public void run() {
        System.out.println("ola mundo");
    }
}
