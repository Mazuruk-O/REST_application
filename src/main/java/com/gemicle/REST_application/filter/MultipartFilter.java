package com.gemicle.REST_application.filter;

import com.gemicle.REST_application.exception.HouseException;
import com.gemicle.REST_application.exception.HouseNotFound;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

public class MultipartFilter implements Filter {
    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
            throws IOException, ServletException {


        if(request.getContentType() != null && request.getContentType().toLowerCase().contains("multipart/form-data")) {

            System.out.println("houseData param: " + request.getParameter("houseData") + "\n");

            System.out.println("imgPart param: " + request.getParameter("imgPart") + "\n");

            filterchain.doFilter(request, response);

        } else {
            throw new HouseException("Not correct data in MultipartFilter");
        }

    }

    @Override
    public void init(FilterConfig filterconfig) throws ServletException {}
}