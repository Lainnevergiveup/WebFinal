package daos;

import beans.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper {
    List<Question> selectByCid(@Param("cid") String cid);
    int insertQuestion(Question question);
    int updateQuestion(Question question);
    int deleteQuestion(@Param("qid")int qid);
    Question selectByQid(@Param("qid") int qid);

}
