package com.telefonica.gal.apidemo;

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
import org.springframework.beans.factory.annotation.Autowired;

public class WatchingFileService {
	
	@Autowired
	static ConfigService confserv;
	
	static WatchService watchServ;
	WatchKey wKey;
//	JSONObject conf = new JSONObject("C:/Develop/STSWorkspace/demo/directory/conf.json");
	static JSONObject conf;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		Path dirPath = Paths.get("C:/Develop/STSWorkspace/demo/directory");
		conf = ConfigService.chargeConf();
		WatchingFileService wDir = new WatchingFileService(dirPath);
		wDir.processEvents();
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
						conf = ConfigService.chargeConf();
					}
				}
				wKey.reset();
			}

		}
	}
}
