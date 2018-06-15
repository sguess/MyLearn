package com.sguess;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.annotation.PostConstruct;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.springframework.stereotype.Service;

@Service
public class SeleniumService {
	@PostConstruct
	public void init() {

	}

	public static void main(String[] args) throws ParseException {
		// new SeleniumService().init();
		// new SeleniumService().fun1();
		 new SeleniumService().fun2();
//		new SeleniumService().fun3();
//		new SeleniumService().fun4();

	}

	private void fun2() {
		String command = "cmd /k java -jar selenium-server-standalone-3.3.1.jar -role hub";
//		command="cmd /c dir";
		try {
			Process process = Runtime.getRuntime().exec(command);
			process.waitFor();
			BufferedInputStream bis = new BufferedInputStream(process.getInputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(bis));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

			process.waitFor();
			if (process.exitValue() != 0) {
				System.out.println("error!");
			}

			bis.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	private void fun4() {
		String command = "cmd /c java -jar selenium-server-standalone-3.3.1.jar -role hub";
//		command="cmd /c dir";
		try {
			Runtime runtime = Runtime.getRuntime();
			runtime.addShutdownHook(new Thread() {

				@Override
				public void run() {
					try {
						Runtime.getRuntime().exec("cmd /c taskkill -f -im java*");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			});
			Process process = runtime.exec(command);
			BufferedInputStream bis = new BufferedInputStream(process.getInputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(bis));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

			process.waitFor();
			if (process.exitValue() != 0) {
				System.out.println("error!");
			}

			bis.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}


	private void fun1() throws ParseException {
		Options options = new Options();
		Option opt = new Option("n", "namesrvAddr", true,
				"Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876");
		opt.setRequired(false);
		options.addOption(opt);
		CommandLineParser parser = new DefaultParser();
		String[] arg = {};
		CommandLine commandLine = parser.parse(options, arg);
		String optNmae = "n";
		if (commandLine.hasOption(optNmae)) {
			System.out.println(commandLine.getOptionValue(optNmae));
			for (String s : commandLine.getOptionValues(optNmae)) {
				System.out.print(s + " ");
			}
		}

	}

	private void fun3() {

	}

}
