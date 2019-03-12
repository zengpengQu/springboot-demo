package com.cmahrmobile.hr.filter;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Title: LoginFilter
 * @Description: 登录过滤器
 * @Copyright: 公共服务与应急管理战略本部 Copyright(c)2017
 * @Date: 2019年01月15
 * @author: 王勇强 (wangyongq@mail.taiji.com.cn)
 * @version: 1.0
 */
@Component
@ServletComponentScan
@WebFilter(urlPatterns = "/", filterName = "loginFilter")
public class LoginFilter implements Filter {

    private String machineCodeOne = "@96@98@101@104@100@107@100@97@102@97@98@107@98@96@99@100@103@104";

    private String machineCodeTwo;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String userCode = servletRequest.getParameter("code");
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        /*if (!machineCodeOne.equals(userCode)){
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/authorization.html");
        }else {*/
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/index.html");
        //}
    }

    @Override
    public void destroy() {

    }
}
