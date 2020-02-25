/**
 * 
 */
package com.vijay.test.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/suggestion")
public class TestController {


	@GetMapping(path = "/typeAhead")//, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	private Flux<TypeAheadObject> typeAheadSearch(
			@RequestParam(value = "prefix") @Size(min = 3, max = 100) String prefix,
			@RequestParam(value = "searchType", required = false, defaultValue = "all") String searchType,
			@RequestParam(value = "languages", required = false, defaultValue = "eng,spa") List<String> languages,
			@RequestParam(value = "size", required = false, defaultValue = "5") int size,
			@RequestParam(value = "suggesterType") String suggesterType) {
		return create();
	}
	
	private Flux<TypeAheadObject> create() {
		List<String> strings = Arrays.asList("vijay", "hello", "workd");
		Flux<TypeAheadObject> vals = Flux.create(flux -> {
			strings.forEach(hit -> {
				TypeAheadObject aheadObject = new TypeAheadObject(hit);
				flux.next(aheadObject);				
			});
			flux.complete();
		});
		return vals;
	}
	
	@Data
	class TypeAheadObject {
		private String value;
		private Map<String, String> extras;
		public TypeAheadObject(String value) {
			super();
			this.value = value;
		} 
		
	}
}
