package com.sguess.ctrl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/")
public class ApiCtrl {
	private static final Logger log = LoggerFactory.getLogger(ApiCtrl.class);

	@PostMapping(value = "cmd")
	public String callCmd(@RequestBody String command) throws IOException, InterruptedException {
		log.info("The command is " + command);
		String resultLog = "";
		String[] commandSplit = command.split(" ");
		List<String> lcommand = new ArrayList<String>();
		for (int i = 0; i < commandSplit.length; i++) {
			lcommand.add(commandSplit[i]);
		}

		ProcessBuilder processBuilder = new ProcessBuilder(lcommand);
		processBuilder.redirectErrorStream(true);
		Process p = processBuilder.start();
		InputStream is = p.getInputStream();
		BufferedReader bs = new BufferedReader(new InputStreamReader(is));

		p.waitFor();
		if (p.exitValue() != 0) {
			// 说明命令执行失败
			// 可以进入到错误处理步骤中
		}
		String line = null;
		while ((line = bs.readLine()) != null) {
			// System.out.println(line);
			resultLog += line;
		}
		System.err.println("--->" + resultLog);
		return resultLog;
	}
}
