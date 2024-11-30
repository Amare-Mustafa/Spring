package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //getting the instance of the IOC(where all the objects are created)
        //we have the ioc container but we have to create the objects in the "spring.xml" file
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        //Laptop lp = (Laptop) context.getBean("laptop");//we use the id to referance which object in the xml(ioc)
        //lp.compile();

        Dev devObj =context.getBean(Dev.class);
        devObj.build();

        //we can
        System.out.println(devObj.getAge());//this will get us the age
        //but we can also set the values in the xml definition

    }
}
