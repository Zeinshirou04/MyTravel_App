package helpers.migration.scheme;

public class CustomerTableScheme {
    protected String query = """
            CREATE TABLE IF NOT EXISTS `customer` (
                `id` INTEGER PRIMARY KEY AUTOINCREMENT,
                `nama` VARCHAR(255) NOT NULL,
                `contact` VARCHAR(13) NOT NULL
            );
             """;

    public String getQuery() {
        return this.query;
    }
}
