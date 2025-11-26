package fr.ubo.hello.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogInterceptor implements MethodInterceptor {
    public Object invoke ( final MethodInvocation invocation ) throws Throwable {
        try{
            System.out.println("Aspect executée avant");
            return invocation.proceed();
        }finally {
            System.out.println("Aspect executée après");

        }

    }

}
