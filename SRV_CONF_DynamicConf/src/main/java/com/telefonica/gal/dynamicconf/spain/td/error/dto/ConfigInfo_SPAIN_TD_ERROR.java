package com.telefonica.gal.dynamicconf.spain.td.error.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.telefonica.gal.dynamicconf.generic.dto.MessageResponse;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(Include.NON_NULL)
public class ConfigInfo_SPAIN_TD_ERROR extends MessageResponse{
	
	private ErrorSpainTDInfo errorInfo;
	
	public ConfigInfo_SPAIN_TD_ERROR(ErrorSpainTDInfo errorInfo) {
		super(errorInfo==null?"KO":"OK", errorInfo==null?"No Data Found":null);
		this.errorInfo =  errorInfo;
	}
	
}
