import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Network {
    public static void main(String[] args) throws IOException {
        // Declare variables
        Router router;
        ArrayList<Device> devices = new ArrayList<>();

        // Create Scanner for user input
        Scanner input = new Scanner(System.in);
        // Create FileWriter to write output to a file
        FileWriter fw = new FileWriter("output.txt");

        // Prompt user for the number of WI-FI connections
        System.out.println("What is the number of WI-FI Connections?");
        int N = input.nextInt();

        // Prompt user for the number of devices clients want to connect
        System.out.println("What is the number of devices Clients want to connect?");
        int TC = input.nextInt();

        // Create a router with N WI-FI connections
        router = new Router(N);

        // Collect information for each device and add it to the devices list
        for (int i = 0; i < TC; i++) {
            String name = input.next();
            String type = input.next();
            Device d = new Device(name, type, router);
            devices.add(d);
        }

        // Start a thread for each device and write arrival information to the output file
        for (Device dev : devices) {
            Thread thread = new Thread(dev);
            thread.start();
            fw.write("(" + dev.getName() + ")" + "(" + dev.getType() + ") arrived\n");
            fw.write("Connection " + dev.getName() + ": " + dev.getName() + " login\n");
            fw.write("Connection " + dev.getName() + ": " + dev.getName() + " performs online activity\n");
            fw.write("Connection " + dev.getName() + ": " + dev.getName() + " Logged out\n");
        }


        // Close the FileWriter
        fw.close();
    }
}