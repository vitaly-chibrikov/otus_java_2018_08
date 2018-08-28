package ru.otus.lottery;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;

/**
 * https://github.com/vitaly-chibrikov/otus_java_2018_06
 * <p>
 * пишите параметром запуска файл source.csv,
 * запускайте.
 * <p>
 * победили те у кого hash > 1_000_000_000
 */

public class MainStream {
    public static void main(String[] args) throws IOException {
        String salt = "Да прибудет с нами Сила!!!\n" +
                "\n" +
                "ytthefirstbornson\u200BБеги Форест, беги\n" +
                "\n" +
                "Васильев Дмитрий\u200BА в августе такой же набор с розыгрышем будет?\n" +
                "\n" +
                "Victorya Gnevasheva\u200Bhello world\n" +
                "\n" +
                "gr_buza\u200Baquila non captat muscas :)\n" +
                "\n" +
                "Oleg\u200BА можно где-то проверить есть ли мой ящик в списке?";

        Files.lines(Paths.get(args[0]))
                .map(String::trim)
                .map(line -> line.substring(0, !line.contains("@") ? line.length() : line.indexOf("@")))
                .map(line -> line + "\t" + salt)
                .sorted(Comparator.comparingLong(String::hashCode))
                .map(line -> line.hashCode() + "\t" + line.replace(salt, ""))
                .forEach(System.out::println);
    }
}
