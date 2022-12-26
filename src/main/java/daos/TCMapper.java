package daos;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TCMapper {
    List<String> getCourseList(@Param("tid")String tid);
    String getTeacherList(@Param("cid")String cid);
    int unchooseCourse(@Param("cid")String cid,@Param("tid")String tid);
    int updateCourse(@Param("cid")String cid,@Param("tid")String tid);
    int deleteCourse(@Param("cid") String cid);
    int insertCourse(@Param("cid") String cid);
    int deleteByTeacher(@Param("tid")String tid);
}
