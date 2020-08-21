package com.chinabear.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by bear on 2020/8/20
 */

/* https://www.edureka.co/blog/logger-in-java
https://github.com/niv26222/ProcessBuilder/blob/master/ProcessBuilder.java
https://github.com/babydoggins/processbuilder/tree/master/src
org.apache.log4j.* package provides the following levels in descending order:
        FATAL
        ERROR
        WARN
        INFO
        DEBUG

java.util.logging package provides the following levels in descending order:
        SEVERE(HIGHEST LEVEL)
        WARNING
        INFO
        CONFIG
        FINE
        FINER
        FINEST(LOWEST LEVEL)
*/

public class BashExecUtil {

    private static final Logger LOGGER = Logger.getLogger(BashExecUtil.class.getName());

    public int exec (String cmd, String[] env)  {

        String line = null;
        int exitVal = 0;
        Process proc = null;
        BufferedReader stdInput  = null;
        BufferedReader stdError  = null;

        try {
            proc = Runtime.getRuntime().exec(cmd, env);
            //process.waitFor()返回值为0表示成功，1表示失败
            exitVal = proc.waitFor();
            stdInput  = new BufferedReader(new InputStreamReader(proc.getInputStream(), "UTF-8"));
            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            while ((line = stdInput.readLine()) != null) {
                LOGGER.log(Level.INFO ,line);
                System.out.println(line);
            }


            stdError  = new BufferedReader(new InputStreamReader(proc.getErrorStream(), "UTF-8"));
            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((line = stdError.readLine()) != null) {
                LOGGER.log(Level.WARNING, line);
            }
        } catch (IOException | InterruptedException ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
            ex.printStackTrace();
        } finally {
            try {
                if (stdInput != null) {
                    stdInput.close();
                }
                if (stdError != null) {
                    stdError.close();
                }
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, ex.toString(), ex);
                ex.printStackTrace();
            }
        }

        System.out.println(exitVal);
        System.out.println(proc.exitValue());
        return exitVal;
    }

    public int exec (String[] cmd, String[] env) {
        return  1;
    }

    public static void main(String[] args) {

        String[] env = {"PATH=/bin:/usr/bin/:/usr/bin/hadoop/software/hadoop/bin/"};
        String cmd = "hadoop fs  -ls /home/hdp-ads-audit/user/xiongyouguo/word/";

        String cmd_err = "hadoop fs  -ell  /home/hdp-ads-audit/user/xiongyouguo/word/";

        BashExecUtil bashExecUtil = new BashExecUtil();

        bashExecUtil.exec(cmd, env);  //0

        bashExecUtil.exec(cmd_err, env); //255


    }
}
