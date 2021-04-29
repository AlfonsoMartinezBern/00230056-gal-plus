package com.telefonica.gal.dynamicconf.unica.td.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.telefonica.gal.dynamicconf.repository.model.Flow;
import com.telefonica.gal.dynamicconf.unica.bu.repository.model.Route_UNICA_BU;
import com.telefonica.gal.dynamicconf.unica.td.repository.model.Endpoint_UNICA_TD;
import com.telefonica.gal.dynamicconf.unica.td.repository.model.Route_UNICA_TD;

public class DynamicRoutingRepository_UNICA_TD_Routes_Validator {

	public static boolean isValid(ArrayList<Route_UNICA_TD> routes) {
		return isValidFlowsForRoutes(routes) && !isMultipleEndpointsWith_No_Flow(routes)
				&& isAllRequiredParameters(routes) && isMultipleRoutesWithSourceAndReplicas(routes);
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
		for (Route_UNICA_TD route : routes) {
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
		return true; //
	}

	private static boolean isAllFlowsParameters(List<Flow> flows) {
		if (flows == null) {
			return true;
		}

		if (flows.size() < 1) {
			return true;
		}
		for (Flow fl : flows) {
			if (fl.getEndpointID() == null || ((Integer) fl.getStep()) == null || ((Integer) fl.getStep()) == 0
					|| fl.getType() == null)
				return false;
		}
		return true; //
	}

	private static boolean isMultipleRoutesWithSourceAndReplicas(ArrayList<Route_UNICA_TD> routes) {
		for (Route_UNICA_TD route : routes) {
			if (!isMultipleFlowWihtSourceAndReplicas(route.getFlows())) {
				return false;
			}
			if (!isFirstFlowStepTypeSource(route.getFlows())) {
				return false;
			}
		}
		return true;
	}

	private static boolean isMultipleFlowWihtSourceAndReplicas(List<Flow> flows) {
		boolean existSource = false;
		if (flows == null || flows.size() < 1) {
			return true;
		}
		for (Flow flow : flows) {
			if (flow.getType().contains("source")) {
				if (!existSource) {
					existSource = true;
				} else {
					return false;
				}
			} else if (!flow.getType().contains("replica")) {
				return false;
			}
		}
		return existSource;

	}
	
	private static  boolean isFirstFlowStepTypeSource(List<Flow> flows) {
		if (flows == null || flows.size() < 1) {
			return true;
		}
		List<Flow> sortedFlow = flows.stream().sorted(Comparator.comparing(Flow::getStep)).collect(Collectors.toList());
		if(sortedFlow.get(0).getType().contains("source")) {
			return true;
		}
		return false;
	}
}
