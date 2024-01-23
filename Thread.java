// Device class representing a network device
class Device extends Thread {
    private String name, type;
    private Router router;

    // Constructor to initialize a device with a name, type, and router
    Device(String name, String type, Router router) {
        this.name = name;
        this.type = type;
        this.router = router;
    }

    // Run method to simulate device activity
    @Override
    public void run() {
        try {
            router.occupyConnection(name);
            System.out.println("Connection " + name + ": " + name + " login");
            System.out.println("Connection " + name + ": " + name + " performs online activity");
            Thread.sleep(2000);
            System.out.println("Connection " + name + ": " + name + " Logged out");
            router.releaseConnection(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String getType() {
        return type;
    }
}
