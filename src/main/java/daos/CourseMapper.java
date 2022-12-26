package daos;

import beans.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    Course selectCourseByid(@Param("id")String id);
    int updateCourse(Course course);
    int deleteCourse(@Param("id") String id);
    List<Course> getAllCourses();
    int insertCourse(Course course);
}
