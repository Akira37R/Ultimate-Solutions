var maximumPoints = function (edges, coins, k) {
    const n = coins.length;
    const children = Array.from({length: n}, () => []);
    for (const edge of edges) {
        children[edge[0]].push(edge[1]);
        children[edge[1]].push(edge[0]);
    }
    const memo = Array.from({length: n}, () => Array(14).fill(-1));

    const dfs = (node, parent, f) => {
        if (memo[node][f] >= 0) {
            return memo[node][f];
        }
        let res0 = (coins[node] >> f) - k, res1 = coins[node] >> (f + 1);
        for (const child of children[node]) {
            if (child === parent) {
                continue;
            }
            res0 += dfs(child, node, f);
            if (f + 1 < 14) {
                res1 += dfs(child, node, f + 1);
            }
        }
        return memo[node][f] = Math.max(res0, res1);
    };

    return dfs(0, -1, 0);
};

function test() {
    console.log(maximumPoints([[0, 1], [1, 2], [2, 3]], [10, 10, 3, 3], 5));
}

test()