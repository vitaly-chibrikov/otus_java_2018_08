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
 *
 * Ссылка на опрос: https://otus.pw/3dJg/
 */

public class MainStream {
    public static void main(String[] args) throws IOException {
        String salt = "Serj Reds\u200BСъешь ещё этих мягких французских булок, да выпей же чаю.\n" +
                "\n" +
                "Данила Икрянников\u200Bпри коллизии хэша сортировка не детерминирована\n" +
                "\n" +
                "Евгений Витольдович\u200BЛучше 1 раз сделать, чем 100 раз увидеть.\n" +
                "\n" +
                "Dmitry Lyutenko\u200BСовы не те, кем кажутся.\n" +
                "\n" +
                "Евгений Нет\u200BHello, world!";

        Files.lines(Paths.get(args[0]))
                .map(String::trim)
                .map(line -> line.substring(0, !line.contains("@") ? line.length() : line.indexOf("@")))
                .map(line -> line + "\t" + salt)
                .sorted(Comparator.comparingLong(String::hashCode))
                .map(line -> line.hashCode() + "\t" + line.replace(salt, ""))
                .forEach(System.out::println);
    }
}
