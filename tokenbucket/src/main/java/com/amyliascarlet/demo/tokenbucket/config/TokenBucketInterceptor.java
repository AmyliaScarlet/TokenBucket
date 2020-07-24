package com.amyliascarlet.demo.tokenbucket.config;

import com.amyliascarlet.demo.tokenbucket.api.RequireToken;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenBucketInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws BucketManagerException {
        //不相干的
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        boolean isAssignableFrom = handler.getClass().isAssignableFrom(HandlerMethod.class);
        //有注解的
        if(isAssignableFrom){
            RequireToken assertTokenBucket = ((HandlerMethod) handler).getMethodAnnotation(RequireToken.class);
            //有RequireToken注解的
            if(assertTokenBucket == null || assertTokenBucket.BucketName().equals("")){
                return true;
            }else {

                int token = BucketManager.getInstance().getBucket(assertTokenBucket.BucketName()).getToken();
                if(token>=0){
                    System.out.println("Bucket:"+ assertTokenBucket.BucketName() +" get token success,surplus:"+token);
                    return true;
                }
                else{
                    System.out.println("Bucket:"+ assertTokenBucket.BucketName()+" none token");
                    return false;
                }
            }
        }
        return true;
    }
}
