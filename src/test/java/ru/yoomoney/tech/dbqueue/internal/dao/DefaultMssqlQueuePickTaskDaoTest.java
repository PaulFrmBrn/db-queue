package ru.yoomoney.tech.dbqueue.internal.dao;

import org.junit.BeforeClass;
import ru.yoomoney.tech.dbqueue.dao.MssqlQueueDao;
import ru.yoomoney.tech.dbqueue.internal.pick.MssqlQueuePickTaskDao;
import ru.yoomoney.tech.dbqueue.utils.MssqlDatabaseInitializer;

/**
 * @author Oleg Kandaurov
 * @author Behrooz Shabani
 * @since 25.01.2020
 */
public class DefaultMssqlQueuePickTaskDaoTest extends QueuePickTaskDaoTest {

    @BeforeClass
    public static void beforeClass() {
        MssqlDatabaseInitializer.initialize();
    }

    public DefaultMssqlQueuePickTaskDaoTest() {
        super(new MssqlQueueDao(MssqlDatabaseInitializer.getJdbcTemplate(), MssqlDatabaseInitializer.DEFAULT_SCHEMA),
                pickTaskSettings -> new MssqlQueuePickTaskDao(MssqlDatabaseInitializer.getJdbcTemplate(),
                        MssqlDatabaseInitializer.DEFAULT_SCHEMA, pickTaskSettings),
                MssqlDatabaseInitializer.DEFAULT_TABLE_NAME, MssqlDatabaseInitializer.DEFAULT_SCHEMA,
                MssqlDatabaseInitializer.getJdbcTemplate(), MssqlDatabaseInitializer.getTransactionTemplate());
    }

    @Override
    protected String currentTimeSql() {
        return "SYSDATETIMEOFFSET()";
    }
}
