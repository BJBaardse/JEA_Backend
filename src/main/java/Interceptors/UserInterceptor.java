package Interceptors;

import model.User;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
// ff google brb
public class UserInterceptor {

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {

        System.out.println("PlayerInterceptor - Logging BEFORE calling method : "+ context.getMethod().getName());

        Object[] result = context.getParameters();
        User p = (User) result[0];
        if(p.getEmail()!= null && p.getPassWd()!= null) {
            System.out.println(p.getEmail() + " - "+ p.getPassWd());
            System.out.println("interceptor.UserInterceptor - Logging AFTER succesfully calling method :"+ context.getMethod().getName() );
            return context.proceed();
        }
        System.out.println("interceptor.UserInterceptor - Logging AFTER canceled calling method :"+ context.getMethod().getName() );

        return null;
    }

}
