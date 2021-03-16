package com.example.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

import org.json.JSONObject;

public class WatchingFileService {

	static WatchService watchServ;
	WatchKey wKey;
//	JSONObject conf = new JSONObject("C:/Develop/STSWorkspace/demo/directory/conf.json");
	static JSONObject conf;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		Path dirPath = Paths.get("C:/Develop/STSWorkspace/demo/directory");
		chargeConf();
		WatchingFileService wDir = new WatchingFileService(dirPath);
		wDir.processEvents();
	}
	
	public static void chargeConf() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(new File("C:/Develop/STSWorkspace/demo/directory/conf.json")));
		String linea, json = "";
		while ((linea = reader.readLine()) != null ) {
			json = json + linea;
		}
		conf = new JSONObject(json);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Servicio: " + conf.getJSONObject("example1").get("servicio"));
		System.out.println("EndPoint: " + conf.getJSONObject("example1").get("endpoint"));
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

	public WatchingFileService(Path dirPath) throws IOException {
		watchServ = FileSystems.getDefault().newWatchService();
		dirPath.register(watchServ, StandardWatchEventKinds.ENTRY_MODIFY);
	}

	public void processEvents() throws InterruptedException, IOException {
		while (true) {
			wKey = watchServ.take();
			if (wKey.isValid()) {
				List<WatchEvent<?>> events = wKey.pollEvents();

				for (WatchEvent<?> event : events) {
					Path path = (Path) event.context();
					if (((Path) event.context()).endsWith("conf.json")) {
						Kind<?> kindOfEvent = event.kind();
						System.out.println("-----------------------------------------------------");
						System.out.println(
								String.format("Evento '%s' detectado en archivo/carpeta '%s'", kindOfEvent.name(), path));
						System.out.println("-----------------------------------------------------");
							chargeConf();
					}
				}
				wKey.reset();
			}

		}
	}
}
