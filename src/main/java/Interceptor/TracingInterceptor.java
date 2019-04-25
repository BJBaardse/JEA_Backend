package Interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TracingInterceptor {

    @AroundInvoke
    public Object logCall(InvocationContext context) throws Exception{
        LOGGER.log(Level.ALL, "error found at: " + context.getMethod());
        return context.proceed();
    }
    private static final Logger LOGGER = Logger.getLogger( TracingInterceptor.class.getName() );
}