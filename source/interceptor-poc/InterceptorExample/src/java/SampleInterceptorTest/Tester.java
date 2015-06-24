/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SampleInterceptorTest;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;

/**
 *
 * @author jGauravGupta
 */
@Singleton
@LocalBean
@Startup
public class Tester {

    @EJB
    SampleBean sampleBean;

    @PostConstruct
    public void init() {
        sampleBean.test("Hello world", 4);
    }
}