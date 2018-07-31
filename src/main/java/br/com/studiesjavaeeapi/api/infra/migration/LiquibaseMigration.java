package br.com.studiesjavaeeapi.api.infra.migration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.resource.ResourceAccessor;

/**
 * Class responsible for creation/update of the database through Liquibase.
 *
 * @author Roberto Amadeu Neto
 * @since 29/11/2017
 */
@ApplicationScoped
public class LiquibaseMigration {

    private static Connection connection;
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/studies-javaeeapi";
    private static final String DATABASE_USER = "postgres";
    private static final String DATABASE_PASSWORD = "a";
    private static final String STAGE = "development";
    private static final String CHANGELOG_FILE = "liquibase/db.changelog-master.xml";

    /**
     * Executes the creation/update of the database through Liquibase.
     *
     * @param init {@link Object} instance.
     */
    private void migrateDatabase(@Observes @Initialized(ApplicationScoped.class) Object init) {
        ResourceAccessor resourceAccessor = new ClassLoaderResourceAccessor(getClass().getClassLoader());
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);

            JdbcConnection jdbcConnection = new JdbcConnection(connection);
            Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(jdbcConnection);

            Liquibase liquiBase = new Liquibase(CHANGELOG_FILE, resourceAccessor, database);
            liquiBase.update(STAGE);
        } catch (SQLException | LiquibaseException ex) {
            ex.printStackTrace();
        }
    }
}
