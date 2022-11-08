package life.majiang.community.mapper;

import java.util.List;
import life.majiang.community.model.User;
import life.majiang.community.model.UserExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_INFO
     *
     * @mbg.generated Tue Nov 08 14:42:56 CST 2022
     */
    long countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_INFO
     *
     * @mbg.generated Tue Nov 08 14:42:56 CST 2022
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_INFO
     *
     * @mbg.generated Tue Nov 08 14:42:56 CST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_INFO
     *
     * @mbg.generated Tue Nov 08 14:42:56 CST 2022
     */
    int insert(User row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_INFO
     *
     * @mbg.generated Tue Nov 08 14:42:56 CST 2022
     */
    int insertSelective(User row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_INFO
     *
     * @mbg.generated Tue Nov 08 14:42:56 CST 2022
     */
    List<User> selectByExampleWithRowbounds(UserExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_INFO
     *
     * @mbg.generated Tue Nov 08 14:42:56 CST 2022
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_INFO
     *
     * @mbg.generated Tue Nov 08 14:42:56 CST 2022
     */
    User selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_INFO
     *
     * @mbg.generated Tue Nov 08 14:42:56 CST 2022
     */
    int updateByExampleSelective(@Param("row") User row, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_INFO
     *
     * @mbg.generated Tue Nov 08 14:42:56 CST 2022
     */
    int updateByExample(@Param("row") User row, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_INFO
     *
     * @mbg.generated Tue Nov 08 14:42:56 CST 2022
     */
    int updateByPrimaryKeySelective(User row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_INFO
     *
     * @mbg.generated Tue Nov 08 14:42:56 CST 2022
     */
    int updateByPrimaryKey(User row);
}