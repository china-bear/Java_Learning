package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by bear on 2020/8/21
 */
public class JavaRunCommand {

    public static void main(String[] args) {

        String s = null;

        try {

//        	String[] cmdArray = {"/bin/sh","-c", "/etc/init.d/mysql start"};

            String[] cmdArray = {"/bin/bash","-c","echo xyg | sudo -S ls"};

//          Process p = Runtime.getRuntime().exec(cmdarray);

            ProcessBuilder builder = new ProcessBuilder(cmdArray);

            // execute the command
            Process p = builder.start();

            p.waitFor();

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(p.getErrorStream()));

            // read the output from the command

            System.out.println(Arrays.toString(cmdArray));
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }

            System.exit(0);
        }
        catch (IOException | InterruptedException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
