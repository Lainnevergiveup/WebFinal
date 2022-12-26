package daos;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SCMapper {
    List<String> getCourseList(@Param("sid")String sid);
    List<String> getStudentList(@Param("cid")String cid);
    int unchooseCourse(@Param("cid")String cid,@Param("sid")String sid);
    int chooseCourse(@Param("cid")String cid,@Param("sid")String sid);
    int deleteCourse(@Param("cid")String cid);
}
