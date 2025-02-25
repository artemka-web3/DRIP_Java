package drip.remote.server;

public class FaultyConnectionManager implements ConnectionManager{
    @Override
    public Connection getConnection() {
        return new FaultyConnection();
    }
}
