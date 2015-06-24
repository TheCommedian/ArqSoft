/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SampleInterceptorTest;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.interceptor.Interceptors;

/**
 *
 * @author jGauravGupta
 */
@Stateless
@LocalBean
@Interceptors(SampleInterceptor.class)
public class SampleBean {
        
    public void test(String message, int number) {
        System.out.println("SampleBean > test");        
    }
}