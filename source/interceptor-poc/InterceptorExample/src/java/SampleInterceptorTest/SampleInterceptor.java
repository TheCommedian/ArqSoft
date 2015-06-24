package SampleInterceptorTest;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author jGauravGupta
 * 
 * 
 * 
 */

public class SampleInterceptor {
    
    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {
        System.out.println("SampleInterceptor > invoke"); 
        System.out.println("SampleBean > parameter message: " + context.getParameters()[0].toString());
        System.out.println("SampleBean > parameter number: " + context.getParameters()[1].toString());
        return context.proceed();
    }   
}
