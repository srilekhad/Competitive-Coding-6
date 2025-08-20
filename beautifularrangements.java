//Time Complexity: O(n * n!) in the worst case (tries permutations with pruning by divisibility).
//Space Complexity: O(n) for the visited array plus recursion depth.

//Backtrack over positions 1..n, placing unused numbers 1..n.
//At each pos, try any num not visited where num % pos == 0 || pos % num == 0, mark, recurse, then unmark.
//When pos > n, increment count; explore all branches via backtracking.

class Solution {
    int count;
    public int countArrangement(int n) {
        if(n == 0)
        {
            return 0;
        }
        count =0;
        boolean[] visited = new boolean[n+1];
        backtrack(1, n, visited);
        return count;
        
    }

    private void backtrack(int pos, int n , boolean[] vis)
    {
        //base condition
        if(pos > n)
        {
            count++;
            return;
        }

        //logic
        for(int num = 1; num <= n; num++)
        {
            if((!vis[num]) && (num%pos == 0 || pos%num == 0 ))
            {
                vis[num] = true;
                backtrack(pos+1, n, vis);
                vis[num] = false;
            }
        }
    }
}