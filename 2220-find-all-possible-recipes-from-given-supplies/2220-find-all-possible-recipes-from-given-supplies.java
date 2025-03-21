class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        Set<String> availableSupplies = new HashSet<>();
        Map<String, Integer> recipeToIndex = new HashMap<>();
        Map<String, List<String>> dependencyGraph = new HashMap<>();
        
        for(String supply: supplies){
            availableSupplies.add(supply);
        }

        for(int ind = 0; ind < recipes.length; ind++){
            recipeToIndex.put(recipes[ind], ind);
        }

        int[] inDegree = new int[recipes.length];

        for(int i =0; i<recipes.length; i++){
            for(String ingredient: ingredients.get(i)){
                if(!availableSupplies.contains(ingredient)){
                    dependencyGraph.putIfAbsent(ingredient, new ArrayList<String>());
                    dependencyGraph.get(ingredient).add(recipes[i]);
                    inDegree[i]++;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<recipes.length; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        List<String> createdRecipes = new ArrayList<>();
        while(!q.isEmpty()){
            int recipeIdx = q.poll();
            String recipe = recipes[recipeIdx];
            createdRecipes.add(recipe);

            if(!dependencyGraph.containsKey(recipe)) continue;

            for(String dependentRecipe: dependencyGraph.get(recipe)) {
                if(--inDegree[recipeToIndex.get(dependentRecipe)] == 0){
                    q.add(recipeToIndex.get(dependentRecipe));
                }
            }
        }
        return createdRecipes;
    }
}