package com.lecteurfluxRSS.fluxRSS;

import com.lecteurfluxRSS.fluxRSS.models.Channel;
import com.lecteurfluxRSS.fluxRSS.services.ReadRssServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FluxRssApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(FluxRssApplication.class, args);
	}

	/*@Autowired
	ReadRssServiceImpl readRssService;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(FluxRssApplication.class);
		// disable spring banner
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);

	}*/

	@Autowired
	ReadRssServiceImpl readRssService;

	@Override
	public void run(String... args) throws Exception {

		readRssService.saveRss();

	}


}
