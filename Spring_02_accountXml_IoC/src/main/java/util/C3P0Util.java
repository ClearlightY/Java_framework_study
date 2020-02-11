package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

public class C3P0Util {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    static {
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql:///ee111");
            dataSource.setUser("root");
            dataSource.setPassword("root");

        } catch (PropertyVetoException e) {
            throw new RuntimeException("初始化数据源失败", e);
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
