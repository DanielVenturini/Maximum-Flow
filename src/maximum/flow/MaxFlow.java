/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximum.flow;
/**
 *
 * @author Daniel
 */
public class MaxFlow {

    static final int V = 6; //numero de vertices do grafo

    int fordFulkerson(int graph[][], int s, int t){

        int u, v;
        int fluxo_maximo = 0;
 
        /* Grafo residual onde Graph_r[i][j] indica a capacidade residual da aresta de i para j.
        */

        int[][] Graph_r = new int[V][V];
 
        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                Graph_r[u][v] = graph[u][v];
 
        // Este vetor eh preenchido pelo BFS e armazena o caminho
        int parent[] = new int[V];
 
        // Enquanto houver caminho do 's' para o 't'
        while (Search.bfs(Graph_r, s, t, parent)){

            // Encontrando a menor capacidade residual
            int fluxo_caminho = Integer.MAX_VALUE;
            for (v = t; v != s; v = parent[v]){
                u = parent[v];
                fluxo_caminho = Math.min(fluxo_caminho, Graph_r[u][v]);
            }
 
            //Atualizando a menor capacidade
            for (v = t; v != s; v = parent[v]){
                u = parent[v];
                Graph_r[u][v] -= fluxo_caminho;
                Graph_r[v][u] += fluxo_caminho;
            }
 
            // Adicionando o fluxo do caminho ao fluxo geral
            fluxo_maximo += fluxo_caminho;
        }
 
        return fluxo_maximo;
    }

}
