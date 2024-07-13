package helpers.migration.scheme;

public class VehiclesTableScheme {
    protected String query = """
            CREATE TABLE IF NOT EXISTS `vehicles` (
                `id` CHAR(5) PRIMARY KEY NOT NULL,
                `vehicle_name` VARCHAR(255) NOT NULL,
                `vehicle_type` VARCHAR(255) NOT NULL,
                `capacity` INT NOT NULL,
                `manufacture` VARCHAR(255) NOT NULL
            );
             """;

    public String getQuery() {
        return this.query;
    }
}
