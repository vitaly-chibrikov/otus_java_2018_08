package ru.otus.lottery;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;

/**
 * https://github.com/vitaly-chibrikov/otus_java_2018_08
 * <p>
 * пишите параметром запуска файл source.csv,
 * запускайте.
 */

public class MainStream {
    public static void main(String[] args) throws IOException {
        String salt = "Remind yourself that overconfidence is a slow and insidious killer";

        Files.lines(Paths.get(args[0]))
                .map(String::trim)
                .map(line -> line.substring(0, !line.contains("@") ? line.length() : line.indexOf("@")))
                .map(line -> line + "\t" + salt)
                .sorted(Comparator.comparingLong(String::hashCode))
                .map(line -> line.hashCode() + "\t" + line.replace(salt, ""))
                .forEach(System.out::println);
    }
}
