package drip.remote.server;

public class ConnectionException extends RuntimeException {
    public ConnectionException(String message, Exception e) {
        super(message);
    }
}
