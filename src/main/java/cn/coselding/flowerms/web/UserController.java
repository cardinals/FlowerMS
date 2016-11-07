package cn.coselding.flowerms.web;

import cn.coselding.flowerms.model.User;
import cn.coselding.flowerms.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 宇强 on 2016/7/13 0013.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(name = "username") String username,
                        @RequestParam(name = "password") String password,
                        HttpSession session,
                        HttpServletResponse response,
                        Model model) {

        User user = userService.login(username, password);
        if (user == null) {
            model.addAttribute("message", "用户名或密码错误！！！");
            return "login";
        } else {
            model.addAttribute("user", user);
            //session保持登陆
            session.setAttribute("user", user);
            //保存cookie，之后可以自动登录
            Cookie usernameCookie = new Cookie("username",username);
            usernameCookie.setMaxAge(60*60*24*7);
            usernameCookie.setPath("/");
            response.addCookie(usernameCookie);
            Cookie passwordCookie = new Cookie("password",password);
            passwordCookie.setMaxAge(60*60*24*7);
            passwordCookie.setPath("/");
            response.addCookie(passwordCookie);
            return "redirect:/user/" + user.getUserID();
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session,
                         Model model) {
        if (session != null && session.getAttribute("user") != null) {
            session.removeAttribute("user");
        }
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/login.jsp";
    }

    @RequestMapping(value = "/{userID}", method = RequestMethod.GET)
    public String info(@PathVariable("userID") int userID,
                       HttpSession session,
                       Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            model.addAttribute("message", "您还未登录！！！");
            return "login";
        } else {
            if (userID == user.getUserID()) {
                model.addAttribute("user", user);
                return "index";
            } else {
                return "redirect:/user/" + user.getUserID();
            }
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "admin_list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "添加管理员");
        return "admin_edit";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String adduser(@RequestParam(name = "username") String username,
                          @RequestParam(name = "password") String password,
                          @RequestParam(name = "email") String email,
                          @RequestParam(name = "tel") String tel,
                          @RequestParam(name = "name") String name,
                          @RequestParam(name = "cardID") String cardID,
                          @RequestParam(name = "address") String address,
                          Model model) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setTel(tel);
        user.setAddress(address);
        user.setCardID(cardID);
        user.setName(name);
        int result = userService.addUser(user);
        if (result >= 1) {
            model.addAttribute("message", "管理员添加成功！！！");
        } else {
            model.addAttribute("message", "管理员添加失败！！！");
        }
        return "message";
    }
}
