package com.telefonica.gal.dynamicconf.spain.td.error.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.telefonica.gal.dynamicconf.generic.dto.MessageResponse;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@JsonInclude(Include.NON_NULL)
public class ConfigInfo_SPAIN_TD_ERROR extends MessageResponse{
	
	private ErrorSpainTDInfo errorInfo;
	
	public ConfigInfo_SPAIN_TD_ERROR(ErrorSpainTDInfo errorInfo) {
		super(errorInfo==null?"KO":"OK", errorInfo==null?"No Data Found":null);
		this.errorInfo =  errorInfo;
	}

	public ErrorSpainTDInfo getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(ErrorSpainTDInfo errorInfo) {
		this.errorInfo = errorInfo;
	}

	@Override
	public String toString() {
		return "ConfigInfo_SPAIN_TD_ERROR{" +
				"errorInfo=" + errorInfo +
				'}';
	}
}
