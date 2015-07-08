package demo.aop.service.impl;

import demo.aop.service.Service;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 08-05-2013 14:45:59
 */
public class ExampleService implements Service {

    @Override
    public String getMessage(String name) {
        return name;
    }

    @Override
    public String getMessage(Double a) {
        return null;
    }

    @Override
    public String getMessage() {
        return "test";
    }

}
