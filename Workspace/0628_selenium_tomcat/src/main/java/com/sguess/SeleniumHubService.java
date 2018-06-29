package com.sguess;

import javax.annotation.PostConstruct;
import org.openqa.grid.selenium.GridLauncherV3;
import org.springframework.stereotype.Service;

@Service
public class SeleniumHubService {
	@PostConstruct
	public void startSeleniumGridHubService() throws Exception {
		String[] arg0 = { "-role", "hub" };
		GridLauncherV3.main(arg0);
	}

}
