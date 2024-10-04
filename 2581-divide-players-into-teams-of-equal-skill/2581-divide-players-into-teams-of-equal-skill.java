class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int totalSkill = 0;
        Map<Integer, Integer> skillMap = new HashMap<>();

        for(int i=0; i<skill.length; i++){
            totalSkill += skill[i]; 
            skillMap.put(skill[i], skillMap.getOrDefault(skill[i],0)+1);
        }

        if(totalSkill%(n/2) != 0) return -1;

        int targetSkill = totalSkill/(n/2); 
        long chemistry=0;

        for(int i: skillMap.keySet()){
            int curr = skillMap.get(i);
            int partner = targetSkill-i;
            if(!skillMap.containsKey(partner)||curr != skillMap.get(partner)){
                return -1;
            }
            chemistry += (long)i*(long)partner*(long)curr;
        }

        return chemistry/2;
    }
}