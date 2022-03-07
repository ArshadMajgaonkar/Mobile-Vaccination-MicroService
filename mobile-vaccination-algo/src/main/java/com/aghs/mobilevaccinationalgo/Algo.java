package com.aghs.mobilevaccinationalgo;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Map.Entry;

public class Algo{
    
    public static List<List<Long>> algorithm(int bagLimit, HashMap<Long, Long> spotMappedSlot)
    {
       /* HashMap<Integer,Integer> spotMappedSlot = new HashMap<Integer,Integer>();
        
        
        spotMappedSlot.put(10200L,200L);
        spotMappedSlot.put(10120L,120L);
        spotMappedSlot.put(100120L,120L);
        spotMappedSlot.put(10110L,110L);
        spotMappedSlot.put(10080L,80L);
        spotMappedSlot.put(1080L,80L);
        spotMappedSlot.put(1060L,60L);
        spotMappedSlot.put(10060L,60L);
        spotMappedSlot.put(1056L,56L);
        spotMappedSlot.put(1030L,30L);*/
        
        // System.out.println(spotMappedSlotm);
        // m = {1001=200, 10002=120, 1100=120, 1011=110, 10102=80, 1265=80, 1233=60};
        
        ArrayList<Long> al = new ArrayList<>();
        
        for(Long val : spotMappedSlot.values())
        {
            al.add(val);
        }
        
        Collections.sort(al, Collections.reverseOrder());
        
        //implementing algo

        List<List<Long>> finalResult = new ArrayList<>();
        
         while(al.size() > 0)
         {
            ArrayList<Long> res = new ArrayList<>();
            int curr_bag_limit = bagLimit;
        
            int it=0;
            
            while( it<al.size() )
            {
                if(al.get(it) <= curr_bag_limit)
                {
                    //finding key from map
                    Long val = al.get(it);
                    
                    for(Entry<Long,Long> entry : spotMappedSlot.entrySet())
                    {
                        if(entry.getValue()==val)
                        {
                            res.add(entry.getKey());
                            spotMappedSlot.remove(entry.getKey());
                            break;
                        }
                    }
                    curr_bag_limit-=al.get(it);
                    al.remove(it);
                    
                }
                else
                    it++;
            }
            finalResult.add(res);
        }
         return finalResult;

    }
}