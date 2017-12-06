/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximum.flow;

import java.util.LinkedList;
import java.util.Stack;
/**
 *
 * @author Daniel
 */
public class MaxFlow {

    static final int V = 6; //Number of vertices in graph

    /* Retorna verdadeiro se houver um caminho de origem 'para afundar' t 'no gráfico residual.
    Também preenche o pai [] para armazenar o caminho */
    boolean bfs(int[][] Graph_r, int s, int t, int[] pai) {

        // crie um array de visitados e marque todos os vertices como nao visitado
        boolean[] visitado = new boolean[V];
        for(int i = 0; i < V; i ++)
            visitado[i] = false;
 
        // crie uma pilha, empilhado o vertice de origem e marcando como visitado
        Stack<Integer> queue = new Stack<>();
        queue.push(s);
        visitado[s] = true;
        pai[s] = -1;
 
        // enquanto houver vertices
        while (!queue.isEmpty()){

            int u = queue.pop();
            for (int v = 0; v < V; v ++){

                if (visitado[v] == false && Graph_r[u][v] > 0){
                    queue.push(v);
                    pai[v] = u;
                    visitado[v] = true;
                }
            }
        }
 
        // se foi atingido o vertice 't' a partir da fonte, entao retorna true, pois tem caminho
        return (visitado[t] == true);
    }

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
        while (bfs(Graph_r, s, t, parent)){

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
