package array;

import java.util.*;
import java.util.stream.Collectors;

public class AccessTime {
    public static void main(String[] argv) {

        String[][] logs1 = new String[][] {
                { "58523", "user_1", "resource_1" },
                { "62314", "user_2", "resource_2" },
                { "54001", "user_1", "resource_3" },
                { "200", "user_6", "resource_5" },
                { "215", "user_6", "resource_4" },
                { "54060", "user_2", "resource_3" },
                { "53760", "user_3", "resource_3" },
                { "58522", "user_22", "resource_1" },
                { "53651", "user_5", "resource_3" },
                { "2", "user_6", "resource_1" },
                { "100", "user_6", "resource_6" },
                { "400", "user_7", "resource_2" },
                { "100", "user_8", "resource_6" },
                { "54359", "user_1", "resource_3"},
        };
        //58523,54001,54359

        String[][] logs2 = new String[][] {
                {"300", "user_1", "resource_3"},
                {"599", "user_1", "resource_3"},
                {"900", "user_1", "resource_3"},
                {"1199", "user_1", "resource_3"},
                {"1200", "user_1", "resource_3"},
                {"1201", "user_1", "resource_3"},
                {"1202", "user_1", "resource_3"}
        };

        String[][] logs3 = new String[][] {
                {"300", "user_10", "resource_5"}
        };
        Map<String, List<Integer>> output=new LinkedHashMap<String,List<Integer>>();;
        AccessTime sol = new AccessTime();
        output=sol.UserSession(logs1);
        System.out.println(output);
    }
    Map<String,List<Integer>> UserSession(String[][] logs)
    {
        //String arr[];
        Map<String,List<Integer>> finalList=new HashMap<String,List<Integer>>();
        Set<String> users=new TreeSet<>();
        for(int i=0;i<logs.length;i++)
        {
            users.add(logs[i][1]);
        }//users
            List<Integer> ls=new ArrayList<>();
            int arr1[][]= new int[users.size()][2];
            int k=0;
            for (String user : users) {
                int minTime = Integer.MAX_VALUE;
                int maxTime = Integer.MIN_VALUE;
                for(int i=0;i<logs.length;i++) {
                    if (user.equals(logs[i][1])) {
                        minTime = Math.min(Integer.parseInt(logs[i][0]), minTime);
                        maxTime = Math.max(Integer.parseInt(logs[i][0]), maxTime);
                    }
                }
                arr1[k][0]=minTime;
                arr1[k][1]=maxTime;
                List<Integer> l = new ArrayList<>();
                l.add(minTime);
                l.add(maxTime);
                finalList.put(user,l);
            }
        Map result = finalList.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return result;
    }
}
//Map<String,List<Integer>>   u, 1,3,6
