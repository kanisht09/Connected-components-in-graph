//
//  main.cpp
//  connected_comp
//
//  Created by datapirate903 on 30/09/20.
//  Copyright © 2020 datapirate903. All rights reserved.
//

#include <iostream>
#include <vector>
using namespace std;

vector <int> adj[10];
bool vis[10];

int temp = 0;

void dfs(int s)
{
    vis[s] = true;

    for (int i = 0; i < adj[s].size(); ++i)
    {
        if (vis[adj[s][i]] == false)
        {
            temp++;
            dfs(adj[s][i]);
        }
    }
}

void initialize()
{
    for (int i = 0; i < 10; ++i)
    {
        vis[i] = false;
    }
}

int main()
{
    int n, m, x, y, ans = 0;

    cout << "ENTER THE NUMBER OF NODES : ";
    cin >> n;

    cout << "ENTER THE NUMBER OF EDGES : ";
    cin >> m;

    cout << "ADD EDGES : ";
    cout << endl;

    for (int i = 0; i < m; ++i)
    {
        cin >> x >> y;
        adj[x].push_back(y);
        adj[y].push_back(x);
    }

    initialize();                           // Initialize all nodes as not visited

    cout << "Length of connected components : ";

    for (int i = 1; i <= n; ++i)
    {
        if (vis[i] == false)
        {
            dfs(i);
            cout << temp << " ";
            temp = 0;
            ans++;
        }
    }
    cout << endl;

    cout << "Number of connected components: " << ans << endl;

    return 0;
}
