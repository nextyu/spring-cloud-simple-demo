package com.nextyu.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * created on 2017-05-27 14:12
 *
 * @author nextyu
 */
public class AccessFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        // Standard types in Zuul are
        // "pre" for pre-routing filtering
        // , "route" for routing to an origin
        // , "post" for post-routing filters
        // , "error" for error handling.
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));



        try {

            if (true) {
                throw new RuntimeException("");
            }

            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                logger.info("{} : {}", headerName, request.getHeader(headerName));
            }

       /* Object accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            logger.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        logger.info("access token ok");*/
        } catch (Exception e) {
            ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            ctx.set("error.exception", e);
        }


        return null;
    }
}
