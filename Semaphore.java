import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Semaphore {
    private int value;

    // Constructor to initialize Semaphore with a given value
    Semaphore(int value) {
        this.value = value;
    }

    // Method for a thread to wait for the semaphore
    synchronized void waitSem(String obj) throws InterruptedException {
        value--;
        if (value < 0) {
            // If no available resource, print message and wait
            System.out.println(obj + " arrived and waiting");
            wait();
        } else {
            // If resource available, print arrival message
            System.out.println(obj + " arrived");
        }
    }

    // Method to signal that a resource is released
    synchronized void signal() {
        value++;
        if (value <= 0) {
            // If waiting threads, notify one of them
            notify();
        }
    }
}

