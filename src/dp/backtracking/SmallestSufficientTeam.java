package dp.backtracking;

import java.util.*;

class SmallestSufficientTeam {
    int max_size;
    HashSet<Integer> resTeam;
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        max_size= people.size()+1;
        Map<String, List<Integer>> adj = new HashMap<>();
        for(int i=0; i<max_size-1; i++){
            for(String skill: people.get(i)){
                List<Integer> temp = adj.getOrDefault(skill, new ArrayList<>());
                temp.add(i);
                adj.put(skill,temp);
            }
        }

        backtrack(adj, req_skills, 0, new HashSet<>());

        int [] res = new int[resTeam.size()];
        int i=0;
        for(Integer iter:resTeam){
            res[i]= iter;
            ++i;
        }
        return res;
    }

    private void backtrack(Map<String, List<Integer>> adj, String[] req_skills, int skillIndex, Set<Integer> team){
        if(team.size()>= max_size){
            return;
        }
        if(skillIndex==req_skills.length){
            if(team.size()<max_size){
                max_size=team.size();
                resTeam = new HashSet<>();
                resTeam.addAll(team);
            }
            return;
        }

        for(Integer people: adj.get(req_skills[skillIndex])){
            boolean ableToAdd = team.add(people);
            backtrack(adj, req_skills, skillIndex+1, team);
            if(ableToAdd)
                team.remove(people);
        }
    }
}
