import java.util.*;
import java.util.Map.Entry;

class Algo{
    
    public static void main(String args[])
    {
        HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
        
        
        m.put(10200,200);
        m.put(10120,120);
        m.put(100120,120);
        m.put(10110,110);
        m.put(10080,80);
        m.put(1080,80);
        m.put(1060,60);
        m.put(10060,60);
        m.put(1056,56);
        m.put(1030,30);
        
        // System.out.println(m);
        // m = {1001=200, 10002=120, 1100=120, 1011=110, 10102=80, 1265=80, 1233=60};
        
        ArrayList<Integer> al = new ArrayList<Integer>();
        
        for(Integer val : m.values())
        {
            al.add(val);
        }
        
        Collections.sort(al, Collections.reverseOrder());
        
        //implementing algo
        
         while(al.size() > 0)
         {
            ArrayList<Integer> res = new ArrayList<Integer>();
            int curr_bag_limit = 300 ;
        
            int it=0;
            
            while( it<al.size() )
            {
                if(al.get(it) <= curr_bag_limit)
                {
                    //finding key from map
                    Integer val = al.get(it);
                    
                    for(Entry<Integer,Integer> entry : m.entrySet())
                    {
                        if(entry.getValue()==val)
                        {
                            res.add(entry.getKey());
                            m.remove(entry.getKey());
                            break;
                        }
                    }
                    curr_bag_limit-=al.get(it);
                    al.remove(it);
                    
                }
                else
                    it++;
            }
            System.out.println(res);
        }

    }
}