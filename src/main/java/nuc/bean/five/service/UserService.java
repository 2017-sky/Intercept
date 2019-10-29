package nuc.bean.five.service;

import nuc.bean.five.dao.UserDao;
import nuc.bean.five.entity.User;
import org.apache.ibatis.annotations.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public  void  insert(User user){
       userDao.insertOne(user);
    }
    public List<User> getList(){ return userDao.list();
    }

}
