package nuc.bean.five.config;

import lombok.Value;
import nuc.bean.five.entity.User;
import nuc.bean.five.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Pattern;
import java.util.*;

@Component
public class UserConfig implements HandlerInterceptor {
    Integer i;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired

    private UserService userService;
    private User user;
    private static final Integer ID_LENGTH = 18;
    private static final Integer PHONE_LENGTH = 11;
    private static List<String> phoneFormat = null;

    static {
        phoneFormat = new ArrayList<>();
        phoneFormat.add("134");
        phoneFormat.add("135");
        phoneFormat.add("136");
        phoneFormat.add("137");
        phoneFormat.add("138");
        phoneFormat.add("139");
        phoneFormat.add("150");
        phoneFormat.add("151");
        phoneFormat.add("158");
        phoneFormat.add("159");
        phoneFormat.add("130");
        phoneFormat.add("131");
        phoneFormat.add("132");
        phoneFormat.add("156");
        phoneFormat.add("133");
        phoneFormat.add("153");
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<User> users = userService.getList();
        String s1 = request.getParameter("idcard");
        String s2 = request.getParameter("name");
        String s3 = request.getParameter("sex");
        String s4 = request.getParameter("phone");
        System.out.println(s1 + "--" + s2 + "--" + s3 + "--" + s4);

        if (s1 == null && s2 == null && s3 == null && s4 == null) {
          logger.info( "数据不能为空");
          map.put("数据不能为空",s1);

          return false;
        }
            if(s1.length()<ID_LENGTH){
                  i=ID_LENGTH -s1.length();
                logger.info("身份证位数少了"+i);
                return false;
            }

            if (s1.length()>ID_LENGTH){
                i = s1.length() - ID_LENGTH;
                logger.info("身份证的位数多了" + i);
                return false;
            }
            if(s1.charAt(16)%2==0) {
                if ("女".equals(s3)) {
                    return true;
                }else {
                    logger.info("你想干啥，男女都不分了啊");
                    return false;
                }
            }
        if(s1.charAt(16)%2!=0){
                if ("男".equals(s3)) {
                    return true;
                }else {
                    logger.info("你想干啥，男女都不分了啊");
                    return false;
                }
            }
            if(s4.length()<PHONE_LENGTH){
                 i = PHONE_LENGTH -s4.length();
                logger.info("电话号码的位数少了"+i);
                return false;
            }
            if (s4.length()>PHONE_LENGTH){
                i=s4.length()-PHONE_LENGTH;
                logger.info("电话号码的位数多了"+i);
             return false;
            }

                if(!phoneFormat.contains(s4.substring(0,3))) {
                    logger.info("请输入正确的电话号码");
                    return false;
                }

        for (User u : users) {
            System.out.println(u);
            System.out.println(s2 + "==="+s4);

            System.out.println("-----------------");
            if (s2.equals(u.getName()) && s4.equals(u.getPhone())) {
                logger.info("该用户已经注册过");
                return false;
            }
            }

          logger.info(user.toString());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }




}
