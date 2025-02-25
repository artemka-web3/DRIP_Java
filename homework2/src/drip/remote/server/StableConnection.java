package drip.remote.server;

public class StableConnection implements Connection {
    @Override
    public void execute(String command) {
        System.out.println("Executing command: " + command);
    }

    @Override
    public void close() {
        System.out.println("Stable connection closed.");
    }
}
