package utils;

import daos.SCMapper;
import daos.TCMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TCUtil {
    InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(resourceAsStream);
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    //User mapper = sqlSession.getMapper(User.class);
    TCMapper mapper = sqlSession.getMapper(TCMapper.class);

    public TCUtil() throws IOException {
    }

    public List<String> getCourseList(String tid){
        return mapper.getCourseList(tid);
    }
    public List<String> getTeacherList(List<String> cids){
        List<String> t = new ArrayList<>();
        for (String s:cids) {
            t.add(mapper.getTeacherList(s));
        }
        return t;
    }
    public int unchooseCourse(String cid,String tid){
        return mapper.unchooseCourse(cid,tid);
    }
    public int updateCourse(String cid,String tid){
        return mapper.updateCourse(cid, tid);
    }
    public String getTeacher(String cid){
        return mapper.getTeacherList(cid);
    }
    public int deleteCourse(String cid){return mapper.deleteCourse(cid);}
    public int insertCourse( String cid){return mapper.insertCourse(cid);}
    public int deleteByTeacher(String tid){
        return mapper.deleteByTeacher(tid);
    }

}
