package io.pivotal.fe.cloudnativemysql;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@SpringBootApplication
@RestController
public class CloudNativeMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudNativeMysqlApplication.class, args);
	}

	@Autowired
	private CounterRepository counterRepository;

	@GetMapping("/")
	public String home() {
		return hello("home");
	}


	@GetMapping("/{page}")
	public String hello(@PathVariable(value = "page", required = false) String page) {
		page = StringUtils.trimToEmpty(page);
		incrementPageCount(page);
		return "Hello There - Here is a summary of page views: " + pageCounts();
	}

	private void incrementPageCount(String page) {
		Optional<Counter> optionalCounter = counterRepository.findByPage(page);
		Counter counter = optionalCounter.isPresent() ? optionalCounter.get() :  new Counter(page);
		counter.setCount(counter.getCount() + 1);
		counterRepository.save(counter);
	}

	private Map<String, Integer> pageCounts() {
		Map<String, Integer> allCounts = new LinkedHashMap<>();
		counterRepository.findAll().forEach(c -> allCounts.put(c.getPage(), c.getCount()));
		return allCounts;
	}

}
