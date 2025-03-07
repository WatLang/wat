package com.kilowatt;

import com.kilowatt.Errors.WattColors;
import com.kilowatt.Executor.WattExecutor;

import java.io.IOException;

/*
Язык программирования WATT
 */
public class Watt {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            warning(WattColors.ANSI_YELLOW + "Invalid usage. Example: watt <script>");
        }
        WattExecutor.run(args[0]);
    }

    public static void warning(String warning) {
        System.out.println(warning);
        System.exit(-1);
    }
}