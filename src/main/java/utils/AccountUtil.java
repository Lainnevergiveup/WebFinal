package utils;

import beans.Account;
import daos.AccountMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountUtil {
    InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(resourceAsStream);
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    //User mapper = sqlSession.getMapper(User.class);
    AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);


    public AccountUtil() throws IOException {
    }

    public Account selectAccountOfId(String id,String psw){
        return mapper.selectAccountOfId(id,psw);
    }
    public Account selectAccountById( String id){
        return mapper.selectAccountById(id);
    }
    public int insertAccount(Account account){
        return mapper.insertAccount(account);
    }
    public int updateAccount(Account account){
        return mapper.updateAccount(account);
    }
    public int deleteAccount(String id){
        return mapper.deleteAccount(id);
    }
    public List<Account> getAllTeachers(){
        return mapper.getAllTeachers();
    }
}
