package utils;

import beans.Course;
import daos.CourseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CourseUtil {
    InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(resourceAsStream);
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    //User mapper = sqlSession.getMapper(User.class);
    CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);

    public CourseUtil() throws IOException {
    }

    public Course selectCourseByid(String id){
        return mapper.selectCourseByid(id);
    }
    public int updateCourse(Course course){
        return mapper.updateCourse(course);
    }
    public int deleteCourse(String id){
        return mapper.deleteCourse(id);
    }
    public List<Course> getAllCourses(){
        return mapper.getAllCourses();
    }
    public int insertCourse(Course course){
        return mapper.insertCourse(course);
    }
}
