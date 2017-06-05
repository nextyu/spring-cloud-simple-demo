package com.nextyu.filter;


import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

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

    @Autowired
    private JWTVerifier verifier;

    @Override
    public String filterType() {
        // Standard types in Zuul are
        // "pre" for pre-routing filtering
        // , "route" for routing to an origin
        // , "post" for post-routing filters
        // , "error" for error handling.
        return FilterConstants.PRE_TYPE;
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

/*
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                logger.info("{} : {}", headerName, request.getHeader(headerName));
            }*/

            // 校验accessToken
            String accessToken = request.getHeader("Authorization");
            if (accessToken == null) {
                logger.warn("access token is empty");
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(HttpServletResponse.SC_FORBIDDEN);
                return null;
            }

            DecodedJWT jwt = verifier.verify(accessToken);
            System.out.println(jwt.getIssuer());
            System.out.println(jwt.getClaim("userId").asInt());

        } catch (JWTVerificationException e) {
            logger.warn("access token is not valid");
            //ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpServletResponse.SC_FORBIDDEN);
            ctx.set("error.status_code", HttpServletResponse.SC_FORBIDDEN);
            logger.error("", e);
            return null;
        } catch (Exception e) {
            ctx.setSendZuulResponse(false);
            ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            ctx.set("error.exception", e);
            logger.error("", e);
            return null;
        }

        logger.info("access token ok");

        return null;
    }
}
