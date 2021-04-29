package com.telefonica.gal.dynamicconf.unica.td.repository;

import java.util.ArrayList;
import java.util.List;

import com.telefonica.gal.dynamicconf.repository.model.Flow;
import com.telefonica.gal.dynamicconf.unica.td.repository.model.Endpoint_UNICA_TD;
import com.telefonica.gal.dynamicconf.unica.td.repository.model.Route_UNICA_TD;

public class DynamicRoutingRepository_UNICA_TD_Routes_Validator {

	public static boolean isValid(ArrayList<Route_UNICA_TD> routes) {
		return isValidFlowsForRoutes(routes) && !isMultipleEndpointsWith_No_Flow(routes) && isAllRequiredParameters(routes);
	}

	private static boolean isMultipleEndpointsWith_No_Flow(ArrayList<Route_UNICA_TD> routes) {
		for (Route_UNICA_TD route : routes) {
			if (route.isMultipleEndpointsWith_No_Flow()) {
				return true;
			}
		}
		return false; //
	}

	private static boolean isValidFlowsForRoutes(ArrayList<Route_UNICA_TD> routes) {
		for (Route_UNICA_TD route : routes) {
			if (!route.isFlowForRoute()) {
				return false;
			}
		}
		return true; //
	}

	public static boolean isAllRequiredParameters(ArrayList<Route_UNICA_TD> routes) {
		for (Route_UNICA_TD route : routes){
			if (!isAllEndpointsParameters(route.getEndpoints()) || !isAllFlowsParameters(route.getFlows()))
			return false;
		}
		return true;
	}

	private static boolean isAllEndpointsParameters(List<Endpoint_UNICA_TD> endpoints) {
		if (endpoints == null)
			return false;
		for (Endpoint_UNICA_TD ep : endpoints) {
			if (ep.getEndpointType() == null || ((Integer) ep.getInstanceID()) == null
					|| ((Integer) ep.getInstanceID()) == 0 || ((Integer) ep.getPlatformID()) == null
					|| ((Integer) ep.getPlatformID()) == 0 || ep.getTargetEndpoint() == null)
				return false;
		}
		return true;  //
	}

	private static boolean isAllFlowsParameters(List<Flow> flows) {
		if (flows == null)
			return true;
		for (Flow fl : flows) {
			if (fl.getEndpointID() == null || ((Integer) fl.getStep()) == null || ((Integer) fl.getStep()) == 0
					|| fl.getType() == null)
				return false;
		}
		return true; //
	}

}
