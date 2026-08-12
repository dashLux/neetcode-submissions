class UnionFind {
    int[] parents;
    int[] ranks;

    public UnionFind(int n) {
        this.parents = new int[n+1];
        this.ranks = new int[n+1];

        for(int i = 0; i < n; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }
    }

    public int find(int x) {
        while (x != parents[x]) {
            parents[x] = parents[parents[x]];
            x = parents[x];
        }
        return x;
    }

    public boolean union(int x1, int x2) {
        int p1 = find(x1);
        int p2 = find(x2);

        if (p1 == p2) {
            return false;
        }

        if (ranks[p1] > ranks[p2]) {
            parents[p2] = p1;
            ranks[p1] += ranks[p2];
        }
        else {
            parents[p1] = p2;
            ranks[p2] += ranks[p1];
        }

        return true;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for(int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[0];
    }
}
