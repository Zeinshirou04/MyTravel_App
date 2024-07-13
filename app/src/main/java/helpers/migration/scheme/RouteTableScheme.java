package helpers.migration.scheme;

public class RouteTableScheme {
    protected String query = """
            CREATE TABLE IF NOT EXISTS `route` (
                `id` INTEGER PRIMARY KEY AUTOINCREMENT,
                `vid` CHAR(5) NOT NULL,
                `dept` VARCHAR(255) NOT NULL,
                `dest` VARCHAR(255) NOT NULL,
                `dept_date` DATETIME NOT NULL,
                `price` INT NOT NULL,
                `stock` INT NOT NULL DEFAULT 0,
                FOREIGN KEY (`vid`) REFERENCES `vehicles` (`id`)
            );
            """;

    public String getQuery() {
        return this.query;
    }
}
