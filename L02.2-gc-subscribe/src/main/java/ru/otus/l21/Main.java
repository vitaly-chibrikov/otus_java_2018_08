package ru.otus.l21;

import com.sun.management.GarbageCollectionNotificationInfo;

import javax.management.NotificationEmitter;
import javax.management.NotificationListener;
import javax.management.openmbean.CompositeData;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * Created by tully.
 * VM options -Xmx512m -Xms512m
 * VM options -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=4000, suspend=n
 * VM options  -javaagent:target/L02.2.jar
 * VM options  -XX:+UseSerialGC
 * -XX:+UseTLAB Uses thread-local object allocation blocks.
 */

@SuppressWarnings("InfiniteLoopStatement")
public class Main {
    public static void main(String... args) throws InterruptedException {
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());

        System.out.println("Object size: " + Agent.instance().getInstrumentation().getObjectSize(new Object()));

        installGCMonitoring();

        int size = 10_000_000;

        run(size);
    }

    private static void run(int size) throws InterruptedException {
        System.out.println("Starting the loop");
        while (true) {
            Object[] array = new Object[size];
            System.out.println("New array of size: " + array.length + " created");
            for (int i = 0; i < size; i++) {
                array[i] = new Object();
            }
            //System.out.println("Created " + size + " objects");
            logs(size);
            Thread.sleep(1000); //wait for 1 sec
        }
    }

    private static void logs(int n) {
        System.out.println("Created " + n + " objects");
    }

    private static void installGCMonitoring() {
        List<GarbageCollectorMXBean> gcbeans = java.lang.management.ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean gcbean : gcbeans) {
            NotificationEmitter emitter = (NotificationEmitter) gcbean;
            System.out.println(gcbean.getName());

            NotificationListener listener = (notification, handback) -> {
                if (notification.getType().equals(GarbageCollectionNotificationInfo.GARBAGE_COLLECTION_NOTIFICATION)) {
                    GarbageCollectionNotificationInfo info = GarbageCollectionNotificationInfo.from((CompositeData) notification.getUserData());

                    long duration = info.getGcInfo().getDuration();
                    String gctype = info.getGcAction();

                    System.out.println(gctype + ": - "
                            + info.getGcInfo().getId() + ", "
                            + info.getGcName()
                            + " (from " + info.getGcCause() + ") " + duration + " milliseconds");

                }
            };

            emitter.addNotificationListener(listener, null, null);
        }
    }
}
