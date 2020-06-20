package com.parag.streams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.parag.streams.model.Stream;
import com.parag.streams.service.StreamService;

/**
 * 
 * @author parag
 *
 */
@SpringBootApplication
public class StreamsApplication implements CommandLineRunner{

	
	@Autowired
	private StreamService streamService;	
	
	/**
	 * Launches the Application
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(StreamsApplication.class, args);
	}

	/**
	 * create the stream when application get started into h2 database
	 * @param args
	 */
	@Override
	public void run(String... args) throws Exception {
		Stream s2= new Stream();
		s2.setId(1L);
		s2.setTitle("Parag");
		s2.setDescription("descrption1");
		s2.setUserId("103268839780042532859");
		streamService.createStream(s2);
		
		
		
	}
}
