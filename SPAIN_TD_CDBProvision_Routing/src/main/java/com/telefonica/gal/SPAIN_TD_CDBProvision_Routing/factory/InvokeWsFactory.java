package com.telefonica.gal.SPAIN_TD_CDBProvision_Routing.factory;

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
