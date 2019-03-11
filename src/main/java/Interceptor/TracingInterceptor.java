package Interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class TracingInterceptor {

    @AroundInvoke
    public Object logCall(InvocationContext context) throws Exception{
        System.out.println("Invoking method: " + context.getMethod());
        return context.proceed();
    }
}