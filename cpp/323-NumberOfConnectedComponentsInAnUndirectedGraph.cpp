class Solution {
private:
    vector<int> parents;
    int find(int x){
        while (x != parents[x]){
            parents[x] = parents[parents[x]]; //path compression (optional)
            x = parents[x];
        }
        return x;
    }

    bool unions(int p, int q){
        int x = find(p);
        int y = find(q);
        if (x != y){
            parents[x] = y;
            return true;
        }
        return false;
    }

public:
    int countComponents(int n, vector<pair<int, int>>& edges) {
        parents.resize(n);
        for (int i = 0; i < n; i++){
            parents[i] = i;
        }
        int count = n;
        for (pair<int, int>& edge : edges){
            if (unions(edge.first, edge.second)){
                count--;
            }
        }
        return count;
    }
};

//DFS
class Solution {
public:
    int countComponents(int n, vector<pair<int, int>>& edges) {
        int count = 0;
        vector<bool> visited(n);
        vector<vector<int>> graph(n);

        if (n == 0){
            return 0;
        }

        for (auto& edge : edges){
            graph[edge.first].push_back(edge.second);
            graph[edge.second].push_back(edge.first);
        }

        for (int i = 0; i < n; i++){
            if (!visited[i]){
                count++;
            }
            dfs(i, visited, graph);
        }
        return count;
    }

    void dfs(int i, vector<bool>& visited, vector<vector<int>>& graph){
        if (visited[i]){
            return;
        }
        visited[i] = true;
        for (int j = 0; j < graph[i].size(); j++){
            dfs(graph[i][j], visited, graph);
        }
    }
};
