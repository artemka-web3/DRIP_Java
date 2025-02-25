package drip.remote.server;

import drip.remote.server.Connection;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts){
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    // Метод для обновления пакетов
    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    public void tryExecute(String command) {
        int attempts = 0;
        while (attempts < maxAttempts) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command); // Пытаемся выполнить команду
                return; // Если команда выполнена успешно, выходим из метода
            } catch (Exception e) {
                attempts++;
                System.out.println("Attempt " + attempts + " failed: " + e.getMessage());
                if (attempts == maxAttempts) {
                    throw new ConnectionException("Failed to execute command after " + maxAttempts + " attempts.", e);
                }
            }
        }
    }
}
