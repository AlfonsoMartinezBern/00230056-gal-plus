package com.telefonica.gal.RTG_SPAIN_TD_HELPDESK.factory;

import com.telefonica.gal.interfaceWs.InvokeWs;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class InvokeWsFactory {
    protected InvokeWs invokeWs;
    protected String type;
    protected boolean synchronous;


}
