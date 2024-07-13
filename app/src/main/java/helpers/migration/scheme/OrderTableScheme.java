package helpers.migration.scheme;

public class OrderTableScheme {
    protected String query = """
            CREATE TABLE IF NOT EXISTS `order` (
                `id` INTEGER PRIMARY KEY AUTOINCREMENT,
                `cid` INT NOT NULL,
                `rid` INT NOT NULL,
                `amount` INT NOT NULL,
                `total` INT NOT NULL,
                `status` INT NOT NULL DEFAULT 0,
                FOREIGN KEY (`cid`) REFERENCES `customer` (`id`),
                FOREIGN KEY (`rid`) REFERENCES `route` (`id`)
            );
             """;

    public String getQuery() {
        return this.query;
    }
}
