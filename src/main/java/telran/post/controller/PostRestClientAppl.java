package telran.post.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import telran.post.dto.PostDto;

public class PostRestClientAppl {

	public static void main(String[] args) throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		RequestEntity<String> requestEntity = 
				new RequestEntity<>(HttpMethod.GET, new URI("https://jsonplaceholder.typicode.com/posts?userId=5"));
		ResponseEntity<List<PostDto>> responseEntity = 
				restTemplate.exchange(requestEntity, new ParameterizedTypeReference<List<PostDto>>() {});
		System.out.println(responseEntity.getStatusCodeValue());
		System.out.println(responseEntity.getHeaders().get("Content-Type"));
		List<PostDto> posts = responseEntity.getBody();
		for (PostDto postDto : posts) {
			System.out.println(postDto);
		}

	}

}
