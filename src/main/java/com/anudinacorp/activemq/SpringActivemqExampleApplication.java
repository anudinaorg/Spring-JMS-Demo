package com.anudinacorp.activemq;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import com.anudinacorp.activemq.services.Consumer;
import com.anudinacorp.activemq.services.Producer;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class })
@EnableJms
public class SpringActivemqExampleApplication implements CommandLineRunner{

	@Autowired
	Producer pro;
	@Autowired
	Consumer cos;
	public static void main(String[] args) {
		SpringApplication.run(SpringActivemqExampleApplication.class, args);
	}
	
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("MY_MQ_V1");
	}

	@Override
	public void run(String... arg0) throws Exception {
		pro.sendMessage("<MY FIRST MESSAGE ARRIVED HERE>");		
		
		
		System.out.println("MESSAGE SENT PROPERLY LETS RECIEVE MESSAGE");
		
	}
}
