// Router class representing a network router
class Router {
    private Semaphore semaphore;

    // Constructor to create a router with a maximum number of connections
    Router(int maxConnections) {
        semaphore = new Semaphore(maxConnections);
    }

    // Method for a device to occupy a connection
    void occupyConnection(String deviceName) throws InterruptedException {
        semaphore.waitSem("Connection: " + deviceName + " trying to connect");
        System.out.println("Connection " + deviceName + ": " + deviceName + " Occupied");
    }

    // Method to release a connection
    void releaseConnection(String deviceName) {
        semaphore.signal();
        System.out.println("Connection " + deviceName + ": " + deviceName + " Released");
    }
}

