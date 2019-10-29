package nuc.bean.five.controller;

import nuc.bean.five.entity.User;
import nuc.bean.five.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.management.Agent;

@Controller
public class UserController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;
//@RequestParam("idcard") String idcard ,@RequestParam("name") String name,@RequestParam("sex") String sex,@RequestParam("phone") String phone
    @RequestMapping("/insert")
    @ResponseBody
    public ModelAndView getOne(@RequestParam("idcard") String idcard , @RequestParam("name") String name, @RequestParam("sex") String sex, @RequestParam("phone") String phone){

        User user = new User(idcard,name,sex,phone);
        userService.insert(user);
        logger.info(idcard+"--->"+name+"--->"+sex+"--->"+phone);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        modelAndView.addObject("user",user);
        return modelAndView;
    }
//    @RequestMapping("/insert")
//    @ResponseBody
//    public String getOne(@RequestBody User user){
//        userService.insert(user);
//        return "ok";
//    }

}
