package com.jxufe.sight;

import com.jxufe.sight.mapper.SightCommentsInfoMapper;
import com.jxufe.sight.properties.WordCloudProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SightApplication.class)
public class TestDataSource {
    @Autowired
    DataSource dataSource;
    @Autowired
    WordCloudProperties properties;
    @Autowired
    SightCommentsInfoMapper sightCommentsInfoMapper;

    @Test
    public void t1() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection=dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
