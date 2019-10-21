package com.wl.www.dbtools;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class GetsqlSession {
    public static SqlSession getSqlSession()throws IOException {
        String configFile="mybatis-config.xml";
        InputStream configStream= Resources.getResourceAsStream(configFile);
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(configStream);
        SqlSession session=factory.openSession();
        return session;
    }
}
