package mk.ukim.finki.projectapp.bootstrap;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional
public class DatabaseCleaner {

    @PersistenceContext
    private EntityManager entityManager;

    private final List<String> tableNames = List.of(
            "evaluations", "answers", "questions",
            "versions", "hef_users", "models"
    );

    public void clean() {
        entityManager.flush();

        // Disable foreign key constraints (PostgreSQL syntax)
        entityManager.createNativeQuery("SET session_replication_role = replica").executeUpdate();

        // Truncate tables and reset sequences
        for (String tableName : tableNames) {
            entityManager.createNativeQuery("TRUNCATE TABLE " + tableName + " CASCADE").executeUpdate();
            entityManager.createNativeQuery("ALTER SEQUENCE " + tableName + "_id_seq RESTART WITH 1").executeUpdate();
        }

        // Re-enable foreign key constraints
        entityManager.createNativeQuery("SET session_replication_role = DEFAULT").executeUpdate();
    }
}