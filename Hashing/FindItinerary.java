package Hashing;

import java.util.HashMap;

public class FindItinerary {

    public static String getTicket(HashMap<String, String> tickets){
        //create reverse map to find the starting location
        HashMap<String, String> revmap = new HashMap<>();

        for(String key : tickets.keySet()){
            revmap.put(tickets.get(key), key);
        }

        //now check which location is not in key location to get starting location
        for(String key : tickets.keySet()){
            if(!revmap.containsKey(key)){
                return key;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getTicket(tickets);
        System.out.print(start + "->");
        for(@SuppressWarnings("unused") String key : tickets.keySet()){
            System.out.print(tickets.get(start)+ "->");
            start = tickets.get(start);
        }
    }
}
