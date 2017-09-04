package com.ai.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class Car implements BeanFactoryAware {
	private IEngine engine;
	BeanFactory factory = null;

	public Car() {
		System.out.println("Car()");
	}

	public void drive(String manuf) {
		if (manuf.equals("hondaEngine")) {
			engine = factory.getBean("hondaEngine", IEngine.class);
		} else if (manuf.equals("yamahaEngine")) {
			engine = factory.getBean("yamahaEngine", IEngine.class);
		}
		engine.start();
	}

	public void setBeanFactory(BeanFactory factory) throws BeansException {
		System.out.println("setBeanFactory()");
		this.factory = factory;
	}

}
