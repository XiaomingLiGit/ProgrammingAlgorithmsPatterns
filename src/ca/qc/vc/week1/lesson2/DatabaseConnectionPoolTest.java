package ca.qc.vc.week1.lesson2;

class DatabaseConnectionPool {

    private static final DatabaseConnectionPool INSTANCE =
            new DatabaseConnectionPool();

    private DatabaseConnectionPool() {
        // Initialize a pool of reusable database connections
    }

    public static DatabaseConnectionPool getInstance() {
        return INSTANCE;
    }

    public void getConnection() {
        System.out.println("Providing a database connection.");
    }
}

public class DatabaseConnectionPoolTest {
    public static void main(String[] args) {
        DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();
    }
}
