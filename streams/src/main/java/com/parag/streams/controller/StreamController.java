package com.parag.streams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parag.streams.model.Stream;
import com.parag.streams.service.StreamService;

/**
* The StreamController controller handles all the incoming requests
*
* @author  Parag P Naik
* @version 1.0
* @since   2020-06-20 
*/

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StreamController {

	@Autowired
	private StreamService streamService;
	
	/**
	 * 
	 * @return all the list of available streams
	 * 
	 */

	@GetMapping("/streams")
	public List<Stream> fetchStreams() {
		return streamService.getStreams();
	}

	/**
	 * 
	 * @param stream incoming request containing value of all required fields to generate stream
	 * @return stream with HTTP status CREATED
	 */
	@PostMapping(value="/streams")
	public ResponseEntity<Stream> createStreams(@RequestBody Stream stream) {		
		return new ResponseEntity<Stream>(streamService.createStream(stream),HttpStatus.CREATED);
	}
	
	/**
	 * patch request to update the changed fields in stream
	 * @param stream
	 * @param id
	 * @return streams with HTTP status OK
	 */
	@PatchMapping(value="/streams/{id}")
	public ResponseEntity<Stream> editStreams(@RequestBody Stream stream,@PathVariable("id") Long id) {
		stream.setId(id);
		return new ResponseEntity<Stream>(streamService.editStream(stream),HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param id
	 * @return id of deleted stream with HTTP status OK
	 */
	@DeleteMapping(value="/streams/{id}")
	public ResponseEntity<Long> deleteStreams(@PathVariable("id") Long id) {
		return new ResponseEntity<Long>(streamService.deleteStream(id),HttpStatus.OK);
	}

}
