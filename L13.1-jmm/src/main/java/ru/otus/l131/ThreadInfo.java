package ru.otus.l131;

class ThreadInfo {

    void print() throws InterruptedException {
        //get an object ot the main thread
        Thread mainThread = Thread.currentThread();
        System.out.println("Thread name: " + mainThread.getName());
        //set name to the thread
        mainThread.setName("MyMain");
        //get priority of the main thread
        System.out.println("Thread priority: " + mainThread.getPriority());

        //create new thread with runnable lambda
        Thread thread2 = new Thread(() ->
        {
            try {
                Thread.sleep(10);
                System.out.println("Hello from the thread: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        });
        //set daemon
        thread2.setDaemon(true);

        thread2.start();

        thread2.setPriority(10);

        //join to a the main thread
        thread2.join();

        //get thread state
        System.out.println(Thread.currentThread().getName() + " thread state: " + mainThread.getState());
        System.out.println("thread2 state: " + thread2.getState());
    }
}
