package utils;

import daos.SCMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SCUtil {
    InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(resourceAsStream);
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    //User mapper = sqlSession.getMapper(User.class);
    SCMapper mapper = sqlSession.getMapper(SCMapper.class);

    public SCUtil() throws IOException {
    }
    public List<String> getCourseList(String sid){
        return mapper.getCourseList(sid);
    }
    public List<String> getStudentList(String cid){
        return mapper.getStudentList(cid);
    }
    public int unchooseCourse(String cid,String sid){
        return mapper.unchooseCourse(cid,sid);
    }
    public int chooseCourse(String cid,String sid){
        return mapper.chooseCourse(cid,sid);
    }
    public int deleteCourse(String cid){return mapper.deleteCourse(cid);}
}
