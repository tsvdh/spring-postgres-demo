package com.tsvdh.spring_postgres_demo.db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

public class V2__AddZooData extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        try (var statement = context.getConnection().createStatement()) {
            int startId;
            {
                var resultSet = statement.executeQuery(
                        """
                        INSERT INTO enclosures VALUES
                            (default, 3, 0),
                            (default, 10, 0)
                            RETURNING id
                        """
                );
                resultSet.next();
                startId = resultSet.getInt("id");
            }
            statement.execute(
                    """
                    INSERT INTO animals VALUES
                        (default, %s, 'lion', 500, 0),
                        (default, %s, 'lion', 300, 0)
                    """
                            .formatted(startId, startId)
            );
            for (int i = 0; i < 8; i++) {
                statement.execute(
                        """
                        INSERT INTO animals VALUES
                            (default, %s, 'monkey', %s, 0)
                        """
                                .formatted(startId + 1, 20 + i * 2)
                );
            }
        }
    }
}
