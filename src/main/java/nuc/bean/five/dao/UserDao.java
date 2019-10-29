package nuc.bean.five.dao;

import nuc.bean.five.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    public void  insertOne(User user);
    public List<User> list();


}
