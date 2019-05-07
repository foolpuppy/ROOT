package top.wigon.common;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/18 11:49
 * 阿里巴巴Druid 数据库连接池
 **/
public class DBConnectionPool {
    private static Logger logger = Logger.getLogger(DBConnectionPool.class);
    private static DataSource dataSource;
    private static DBConnectionPool dbConnection;

    /**
     * 静态代码块用于初始化
     */
    static {
        Properties properties = new Properties();
        try {
            //获取配置文件的第一种方法
            String path = DBConnectionPool.class.getClassLoader().getResource("db.properties").getPath();
            properties.load(new FileInputStream(new File(path)));
             /*
            //获取配置文件的第二种方法
            FileInputStream fileInputStream = new FileInputStream("src/db.properties");
            properties.load(fileInputStream);*/
            logger.info("properties path: " + path);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获得实例
     *
     * @return
     */
    public static synchronized DBConnectionPool getInstance() {
        if (dbConnection == null) {
            dbConnection = new DBConnectionPool();
        }
        return dbConnection;
    }

    /**
     * 获取数据库连接
     *
     * @return Connection
     */
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 获得dataSource
     *
     * @return dataSource
     */
    public DataSource getDataSource() {
        return dataSource;
    }

}
