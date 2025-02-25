package drip.remote.server;

public interface Connection extends AutoCloseable{
    void execute(String command) throws ConnectionException;
}
