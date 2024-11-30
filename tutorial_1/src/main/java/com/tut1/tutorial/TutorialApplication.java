package com.tut1.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TutorialApplication {

	public static void main(String[] args) {


		/*
		we create an instance of the object then it's method
		This is a manual creation of an object
		The object is created in the JVM and not in the container which means we have to manage the life cycle of it

		Dev devObj = new Dev();
		devObj.build();
		 */

		/*
		we want to get the object from the spring container
		we need to create a reference of the container type "ApplicationContext"
		which it's self is an object
		 */

		ApplicationContext context = SpringApplication.run(TutorialApplication.class, args);// this will build the ioc (spring container) which will build for us the objects in jvm

		//we get the object created from the container
		Dev devObj = context.getBean(Dev.class);

	}

}
