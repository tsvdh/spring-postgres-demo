package com.tsvdh.spring_postgres_demo.db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

public class V2__AddZooData extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        try (var statement = context.getConnection().createStatement()) {
            statement.execute(
                    """
                    INSERT INTO enclosures VALUES
                        (default, 3, 0),
                        (default, 10, 0)
                    """
            );
            statement.execute(
                    """
                    INSERT INTO animals VALUES
                        (default, 1, 'lion', 500, 0),
                        (default, 1, 'lion', 300, 0)
                    """
            );
            for (int i = 0; i < 8; i++) {
                statement.execute(
                        """
                        INSERT INTO animals VALUES
                            (default, 2, 'monkey', %s, 0)
                        """
                        .formatted(20 + i * 2)
                );
            }
        }
    }
}
