package drip.remote.server;

public class DefaultConnectionManager implements ConnectionManager {
    @Override
    public Connection getConnection() {
        return Math.random() < 0.5 ? new StableConnection() : new FaultyConnection();
    }

}
