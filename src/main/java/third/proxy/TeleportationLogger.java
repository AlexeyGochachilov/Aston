package third.proxy;

@FunctionalInterface
public interface TeleportationLogger {

    public void log(String message);

    static TeleportationLogger consoleLogger() {
        return System.out::println;
    }

    static TeleportationLogger silentLogger() {
        return message -> {};
    }
}
