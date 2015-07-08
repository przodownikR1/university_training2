package demo.aop.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

import demo.aop.service.impl.ElectricianServiceImpl;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 14-04-2013 10:37:11
 */
@Aspect
public class ElectricianIntroducer {
    @DeclareParents(value = "aop.service.CarMechanicService+", defaultImpl = ElectricianServiceImpl.class)
    public static ElectricianService electricianService;
}
