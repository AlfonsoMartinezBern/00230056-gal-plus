package com.telefonica.gal.dynamicconf.unica.error.bu.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.telefonica.gal.dynamicconf.generic.dto.MessageResponse;
import com.telefonica.gal.dynamicconf.repository.model.ErrorInfo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@JsonInclude(Include.NON_NULL)
@Getter
@Setter
@ToString
public class ConfigInfo_UNICA_ERROR_BU extends MessageResponse{

	

	private ErrorInfo errorInfo;
	
	public ConfigInfo_UNICA_ERROR_BU(ErrorInfo errorInfo) {
		super(errorInfo==null?"KO":"OK", errorInfo==null?"No Data Found":null);
		this.errorInfo = errorInfo;
	}
	
}
