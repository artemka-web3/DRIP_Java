package drip.remote.server;

public class FaultyConnection implements Connection{
    @Override
    public void execute(String command) {
        if (Math.random() < 0.5){
            Exception e = new Exception("Connection failed");
            throw new ConnectionException("Connection failed", e);
        }
        System.out.println("Executing command: " + command);
    }

    @Override
    public void close() {
        System.out.println("Faulty connection closed.");
    }
}
