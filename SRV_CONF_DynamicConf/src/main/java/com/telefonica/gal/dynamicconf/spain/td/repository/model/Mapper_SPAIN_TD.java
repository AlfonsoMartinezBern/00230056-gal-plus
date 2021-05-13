package com.telefonica.gal.dynamicconf.spain.td.repository.model;

import com.telefonica.gal.dynamicconf.repository.Repository;
import com.telefonica.gal.dynamicconf.repository.model.ConfigMapper;
import com.telefonica.gal.dynamicconf.repository.model.Flow;
import com.telefonica.gal.dynamicconf.spain.td.controller.RoutingTable_SPAIN_TD;
import com.telefonica.gal.dynamicconf.spain.td.dto.RoutingInfo_SPAIN_TD;
import com.telefonica.gal.dynamicconf.spain.td.dto.RoutingKey_SPAIN_TD;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper_SPAIN_TD implements ConfigMapper {

    @Autowired
    RoutingTable_SPAIN_TD routingTable;

    @Override
    public boolean parse2Dto(Repository repository) {
        if (!repository.isValid()) {
            return false;
        }

        for (Object object :  repository.getMaps()) {
            Route_SPAIN_TD route = (Route_SPAIN_TD) object;
            routingTable.add(parseToRoutingTDKey(route), parseToRoutingTDInfo(route));
        }
        routingTable.setConfigFileVersion(repository.getVersion());
        routingTable.setLastConfigurationTimeStamp(new DateTime());
        routingTable.setConfigFileInfo(repository.getInfo());
        return true;
    }

    private RoutingKey_SPAIN_TD parseToRoutingTDKey(Route_SPAIN_TD route) {
        return new RoutingKey_SPAIN_TD(route.getOperationTD());
    }

    public RoutingInfo_SPAIN_TD parseToRoutingTDInfo(Route_SPAIN_TD route) {
        List<Flow> flows = setFlows(route.getFlows());
        List<Endpoint_SPAIN_TD> enpoints = setEndpoints(flows, route);
        return new RoutingInfo_SPAIN_TD(enpoints, flows);
    }

    private List<Endpoint_SPAIN_TD> setEndpoints(List<Flow> flows, Route_SPAIN_TD route) {
        List<Endpoint_SPAIN_TD> newEndPoints = new ArrayList<Endpoint_SPAIN_TD>();
        if ((route.getFlows() == null && route.getEndpoints().size() == 1)
                || ((flows.isEmpty() || flows == null) && route.getEndpoints().size() == 1)) {
            return route.getEndpoints();
        }

        for (Flow flow : flows) {
            newEndPoints.add(route.getEndpointsById(flow.getEndpointID()));
        }

        return newEndPoints;
    }

    private List<Flow> setFlows(List<Flow> flows) {
        List<Flow> newFlows = new ArrayList<Flow>();
        for (Flow flow : flows) {
            if (flow.isActive()) {
                newFlows.add(flow);
            }
        }
        return newFlows;
    }
}
