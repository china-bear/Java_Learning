package com.chinabear.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bear on 2020/8/21
 */
public class ProcessBuilderDemo {

    public static void main(String[] arg) throws IOException, InterruptedException {
        // creating list of process
        List<String> list = new ArrayList<String>();
        list.add("XXnotepad.exe");
        list.add("a.txt");
        int exitValue = 1 ;

        try {
            // create the process
            ProcessBuilder builder = new ProcessBuilder(list);

            // checking the command in list
            System.out.println("command: " + builder.command());

            // execute the command in list
            Process process = builder.start();

            // Wait to get exit value   SUCCESS: 0, termination: -1, Exception: 1 , others: 255
            exitValue = process.waitFor();

        } catch (IOException ioException) {
            System.out.println("IOException");
            ioException.printStackTrace();
        } catch (InterruptedException interruptedException) {
            System.out.println("interruptedException");
            interruptedException.printStackTrace();
        } finally {
            System.out.println("\n\nExit Value is " + exitValue);
            System.out.println("Finish");
        }

    }

}
