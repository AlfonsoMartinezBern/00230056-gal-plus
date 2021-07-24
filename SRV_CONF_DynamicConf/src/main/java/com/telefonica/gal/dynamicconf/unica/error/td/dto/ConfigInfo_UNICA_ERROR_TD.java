package com.telefonica.gal.dynamicconf.unica.error.td.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.telefonica.gal.dynamicconf.generic.dto.MessageResponse;
import com.telefonica.gal.dynamicconf.repository.model.ErrorInfo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(Include.NON_NULL)
public class ConfigInfo_UNICA_ERROR_TD extends MessageResponse{
	
	private ErrorInfo errorInfo;
	
	public ConfigInfo_UNICA_ERROR_TD(ErrorInfo errorInfo) {
		super(errorInfo==null?"KO":"OK", errorInfo==null?"No Data Found":null);
		this.errorInfo = errorInfo;
	}
	
}
