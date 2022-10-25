package life.majiang.community.mapper;

import life.majiang.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface UserMapper {
    // #{}:当形参为javabean时，#{}中写入javabean的属性，会自动把类中的对应属性的值放入其中
    @Insert("insert into user_info (account_id,name,token,gmt_create,gmt_modified,avatar_url) values (#{accountID},#{name},#{token},#{gmtCreate},#{gmtModified},#{avatarURL})")
    void insert(User user);

    // #{}:当形参为单个值（一般都是一个简单数据类型）时，#{}中写入形参名直接传递即可，不需要额外加@Param注解
    @Select("select * from user_info where token=#{token}")
    User findByToken(String token);

    @Select("select * from user_info where id=#{id}")
    User findByID(Integer id);

    @Select("select * from user_info where account_id=#{accountID}")
    User findByAccountID(String accountID);

    @Update("update user_info set name = #{name}, token = #{token}, gmt_modified=#{gmtModified}, avatar_url=#{avatarURL} where id=#{id}")
    void update(User dbUser);
}