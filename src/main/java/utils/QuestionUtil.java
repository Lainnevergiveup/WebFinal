package utils;

import beans.Question;
import daos.QuestionMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class QuestionUtil {
    InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(resourceAsStream);
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    //User mapper = sqlSession.getMapper(User.class);
    QuestionMapper mapper = sqlSession.getMapper(QuestionMapper.class);

    public QuestionUtil() throws IOException {
    }

    public List<Question> selectByCid(String cid){
        return mapper.selectByCid(cid);
    }
    public int insertQuestion(Question question){
        System.out.println("123"+question);
        return mapper.insertQuestion(question);
    }
    public int updateQuestion(Question question){
        return mapper.updateQuestion(question);
    }
    public int deleteQuestion(int qid){
        return mapper.deleteQuestion(qid);
    }
    public Question selectByQid(int qid){
        return mapper.selectByQid(qid);
    }

}
