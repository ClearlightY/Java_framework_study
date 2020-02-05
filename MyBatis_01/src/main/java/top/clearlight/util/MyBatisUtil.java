package top.clearlight.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static SqlSessionFactory factory;

    static {
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            throw new RuntimeException("初始化SqlSessionFactory失败, 请检查您的配置文件", e);
        }
    }

    public static SqlSession openSession() {
        return factory.openSession();
    }
}
