package daos;

import beans.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {
    Account selectAccountOfId(@Param("id") String id,@Param("psw") String psw);
    Account selectAccountById(@Param("id") String id);

    int insertAccount(Account account);
    List<Account> getAllTeachers();
    int updateAccount(Account account);
    int deleteAccount(@Param("id") String id);
}
