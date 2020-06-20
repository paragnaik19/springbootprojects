package com.parag.streams.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parag.streams.model.Stream;
import com.parag.streams.repository.StreamRepository;

/**
 * contains all database related calls.
 * @author parag
 *
 */
@Service
public class StreamService {

	@Autowired
	private StreamRepository streamRepository;

	public List<Stream> getStreams() {
		return streamRepository.findAll();
	}

	public Optional<Stream> getStream(Long id) {
		System.out.println(id);
		return streamRepository.findById(id);
	}

	public Stream createStream(Stream stream) {
		return streamRepository.saveAndFlush(stream);
	}

	public Stream editStream(Stream stream) {
		return streamRepository.saveAndFlush(stream);
	}

	public Long deleteStream(Long id) {
		streamRepository.deleteById(id);
		return id;
	}

}
