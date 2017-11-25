package com.advorch.director;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * 
 * This class contains the references of
 * all the nodes that have been registered by the Director
 * 
 * It should be responsible of translating logical references of nodes to 
 * actual hostnames, ideally via another framework like Zookeeper 
 */ 
public class NodeResolver {

	// Contains a Map where:
	// Key -> Node Id (Tag)
	// Hostname -> Actual hostname of the node
	private Map<String, String> nodeMap = new LinkedHashMap<String, String>();
	
	public String getNodeHostName(String nodeId) {
		return (nodeMap.get(nodeId));
	}
	
	public List<String> getNodeHostNamesRegex(String regex) {
		List<String> hostNames = new ArrayList<String>();
		
		for (Iterator it = nodeMap.keySet().iterator(); it.hasNext(); ) {
			
		}
		
		return hostNames;
	}
}
