package com.advorch.director;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.advorch.event.Event;
import com.advorch.event.EventType;

public class Command {
	
	private final static String PIPE = "|";

	public static Map interpret(String commandStr) {
		// For now, just a simplified version of the intepreter
		// Initially, just pipe-separated verbs will be processed
		// e.g. [verb1]@node1 | [verb2]@node2 | [verb3]@node3
		
		//EventMap _eventMap = new EventMap(); 
		Map<Event, Event> _eventMap = new HashMap<Event, Event>();		       
			
		String[] verbArr = commandStr.split(PIPE);
		
		if (verbArr.length < 1) {
			return null;
		}
		
		Verb sourceVerb = null;
		Verb targetVerb = null;
		
		for (int i = 0; i < verbArr.length - 1; i++) {
			sourceVerb = Verb.processString(verbArr[i]);
			targetVerb = Verb.processString(verbArr[i + 1]);
			
			_eventMap.put(sourceVerb.nodeId, sourceVerb.action, EventType.END, 
					targetVerb.nodeId, targetVerb.action, EventType.START); 
		}
		
		return _eventMap;
	}
	
	
	static class Verb {
		Pattern p = Pattern.compile("[(.*)]@(.*)");
		
		String action;
		String nodeId;
		SEQUENCER seq = SEQUENCER.NONE;
	
		public static Verb processString(String verbStr) {
			Verb processedVerb = null;
			Matcher m = p.matcher(verbStr);
			
			if (m != null) {
				if (m.find()) {
					 processedVerb = new Verb();
					 processedVerb.action = m.group(1);
					 processedVerb.nodeId = m.group(2);
				}
			}
			
			return processedVerb;
		}
	}
	
	enum SEQUENCER {
		FINISH,
		START,
		NONE
	}
}
