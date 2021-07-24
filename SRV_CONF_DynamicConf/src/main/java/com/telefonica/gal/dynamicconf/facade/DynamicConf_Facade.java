package com.telefonica.gal.dynamicconf.facade;


import com.telefonica.gal.dynamicconf.config.ConfigService;
import com.telefonica.gal.dynamicconf.generic.dto.ConfTable;
import com.telefonica.gal.dynamicconf.generic.dto.MessageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;


public class DynamicConf_Facade<T> implements DynamicConf{

	private ConfigService configService;

	private ConfTable confTable;
	
	private boolean isCharged = false;
	
	public DynamicConf_Facade(ConfigService configService, ConfTable routingTable) {
		super();
		this.configService = configService;
		this.confTable = routingTable;
		
	}

	public ConfigService getConfigService() {
		return configService;
	}

	public void setConfigService(ConfigService configService) {
		this.configService = configService;
	}

	public ConfTable getRoutingTable() {
		return confTable;
	}

	public void setRoutingTable(ConfTable routingTable) {
		this.confTable = routingTable;
	}


	@PutMapping("/charge")
	public MessageResponse chargeConf() {
		isCharged =  configService.chargeConf();

		if (isCharged)
			return new MessageResponse("OK",  confTable.getConfTableInfo());
		else
			return new MessageResponse("KO", "The configFile for "+configService.getDynRoutType()+" at "+configService.getConfigFile() +" was not uploaded");

	}
	
	protected void charge() {
		if(!isCharged) {
			configService.chargeConf();
			isCharged = true;
		}
		
	}

	@GetMapping("/getInfo")
	public MessageResponse isValidConfigFile() {
		if (confTable == null)
			return new MessageResponse("KO", "No se ha cargado la configuración del fichero");
		return new MessageResponse(confTable.isCharge() ? "OK" : "KO",  confTable.getConfTableInfo());
	}

	@GetMapping("/isValidConfigFile")
	public MessageResponse getConfigInfo() {
		return configService.isValidChargeConf() ? new MessageResponse("OK", "The configFile for "+configService.getDynRoutType()+" at "+configService.getConfigFile() +" is valid")
				: new MessageResponse("KO", "The Routing ConfigFile is NOT valid");
	}
	
	@GetMapping("/showFile")
	public T showFile() {
			return (T) configService.getRepository();
	}

	public void isConfigFileCharged() {
		if (!isCharged) {
			isCharged = configService.chargeConf();
		}
	}

}