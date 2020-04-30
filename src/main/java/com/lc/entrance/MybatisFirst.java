package com.lc.entrance;

import com.lc.model.XTest;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author: liuc
 * @date: 2020/4/23
 * @desc:
 */
public class MybatisFirst {
    public static void main(String[] args) {
        String resource = "my-mybatis.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = sqlMapper.openSession();
            try {
                XTest xTest = session.selectOne("com.lc.access.XTestMapper.getObj", "1 or 1 = 1");
                XTest xTest2 = session.selectOne("com.lc.access.XTestMapper.checkObj", "1 or 1 = 1");
                System.out.println(xTest.getId() + ", "+ xTest.getName() + ", " + xTest.getAge() + ", " + xTest.getMoney());
                System.out.println(xTest2.getId() + ", "+ xTest2.getName() + ", " + xTest2.getAge() + ", " + xTest2.getMoney());
            } finally {
                session.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
