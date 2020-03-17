package com.xgk.dao;

import com.xgk.domain.Bill;
import com.xgk.domain.Provider;
import com.xgk.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/2/25 14:24
 */
@Repository
public interface UserDao {

/*    @Update("update smbms_user set userPassword=#{password} where id = #{id}")
    int updateUser(@Param("id") Integer id , @Param("password") String password);

    int updateUserByCondition(@Param("id") Integer id , @Param("password") String password);*/

    int getUserCount();
    User login(User user);
    List<User> getUserList();

    List<User> getUserListBy1(
            @Param("user")User user,
            @Param("from")Integer from,
            @Param("pageSize")Integer pageSize
    );//第一种方式：把参数封装到实体类
    List<User> getUserListBy2(String userName,String userRole);//第二种方式：用参数的下标#{0}
    //第三种方式：用@Param("name"),#{name}
    List<User> getUserListBy3(@Param("userName")String un,@Param("userRole")String ur);
    List<User> getUserListBy4(Map map);//第四种方式：把参数封装到Map中

    List<User> getUserListCollection();

    int addUser(User user);
    int updateUser(User user);
    int deleteUser(Integer id);
    List<User> getUserListByArray(Integer[] roleIds);
    List<User> getUserListByList(List<Integer> roleIds);
    List<User> getUserListByMap(Map roleIds);
    List<User> getUserListByParam(@Param("gender")Integer gender,@Param("roleIds")Integer[] roleIds);
    List<User> getUserListByPage(
            @Param("userName")String userName,
            @Param("userRole")String userRole,
            @Param("from")Integer from,
            @Param("pageSize")Integer pageSize
    );
    List<User> getUserListByPage2(
            @Param("userName")String userName,
            @Param("userRole")String userRole,
            @Param("pageIndex")Integer pageIndex,
            @Param("pageSize")Integer pageSize
    );
    User getUserById(Integer id);
    Integer getUserCountByQuery(User queryUser);
    User checkUserCode(String userCode);
}
