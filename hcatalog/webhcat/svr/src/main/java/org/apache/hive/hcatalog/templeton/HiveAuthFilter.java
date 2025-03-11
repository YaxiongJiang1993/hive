package org.apache.hive.hcatalog.templeton;


import org.apache.hadoop.security.authentication.server.AuthenticationFilter;
import org.apache.hadoop.security.authentication.server.ProxyUserAuthenticationFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HiveAuthFilter extends ProxyUserAuthenticationFilter implements Filter {

    public HiveAuthFilter() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = ProxyUserAuthenticationFilter.toLowerCase((HttpServletRequest)request);
        String tokenString = httpRequest.getParameter("delegation");
        if (tokenString != null && httpRequest.getServletPath().startsWith("/webhdfs/v1")) {
            filterChain.doFilter(httpRequest, response);
        } else {
            super.doFilter(request, response, filterChain);
        }
    }
}
