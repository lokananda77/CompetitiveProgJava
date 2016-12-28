package FbInterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode332 {
	
		public static List<String> findItinerary1(String[][] tickets) {
		    for (String[] ticket : tickets)
		        targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
		    visit("JFK");
		    return route;
		}
	
		static Map<String, PriorityQueue<String>> targets = new HashMap<>();
		static List<String> route = new LinkedList();
	
		static void visit(String airport) {
		    while(targets.containsKey(airport) && !targets.get(airport).isEmpty())
		        visit(targets.get(airport).poll());
		    route.add(0, airport);
		}
	
	    public static List<String> findItinerary(String[][] tickets) {
	        HashMap<String, List<String>> cities = new HashMap<String, List<String>>();
	        List<String> destList;
	        for(String[] ticket: tickets) {
	        	if (cities.get(ticket[0]) == null) {
	        		System.out.println("1");
		            destList = new ArrayList<String>();
	        	} else {
	        		//System.out.println(cities.get(ticket[0]));
	        		System.out.println("2");
	        		destList = cities.get(ticket[0]);
	        	}
	            destList.add(ticket[1]);
	            cities.put(ticket[0], destList);
	        }
	        System.out.println(cities);
	        LinkedList<String> stack = new LinkedList<String>();
	        List<String> visitCities = new ArrayList<String>(); 
	        stack.add("JFK");
	        
	        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
	        
	        while(!stack.isEmpty()) {
	            String vcity = stack.pop();
	            visited.put(vcity, true);
	            System.out.println(vcity.length());
	            System.out.println(vcity);
	            visitCities.add(vcity);
	            List<String>destCities = cities.get(vcity);
	            for (String city: destCities) {
	            	if (visited.get(city) == null) {
	            		stack.add(city);
	            	}
	            }
	            System.out.println(vcity.length());
	        }
	        return visitCities;
	    }
	    
	    public static void main(String[] args) {
	    	String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
	    	System.out.println(findItinerary1(tickets));
		}
	}
