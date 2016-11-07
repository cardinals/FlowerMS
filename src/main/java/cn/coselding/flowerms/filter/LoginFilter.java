package cn.coselding.flowerms.filter;

import cn.coselding.flowerms.model.User;
import cn.coselding.flowerms.service.UserService;
import cn.coselding.flowerms.service.impl.UserServiceImpl;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 管理页面未登陆拦截过滤器
 * Created by 宇强 on 2016/3/12 0012.
 */
public class LoginFilter implements Filter {

    @Resource
    private UserService UserService = new UserServiceImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //初始化http对象
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        //登录操作请求路径
        if(request.getRequestURI().endsWith("/user/login")) {
            filterChain.doFilter(request, response);
            return;
        }

        //检查是否已登录
        User user = (User) session.getAttribute("user");
        if (user == null) {//未登录
            //检查cookie
            Cookie[] cookies = request.getCookies();
            String username = null;
            String password = null;
            if(cookies!=null&&cookies.length>0) {
                for (Cookie c : cookies) {
                    if (c.getName().equals("username")) {
                        username = c.getValue();
                    } else if (c.getName().equals("password")) {
                        password = c.getValue();
                    }
                }
            }
            if(username==null||password==null){
                //未登录，跳转到登录页面
                response.sendRedirect(request.getContextPath() + "/login.jsp");
                return;
            }
            //未登录，跳转到登录页面
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
            //cookie自动登录
//            user = UserService.login(username, password);
//            if (user == null) {//cookie中帐号密码不匹配
//                //未登录，跳转到登录页面
//                response.sendRedirect(request.getContextPath() + "/login.jsp");
//                return;
//            }else{
//                session.setAttribute("user",user);
//            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
