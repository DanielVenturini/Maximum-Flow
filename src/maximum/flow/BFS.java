/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximum.flow;

import java.util.Stack;
import static maximum.flow.MaxFlow.V;

/**
 *
 * @author Daniel
 */
public class BFS {

    /* Retorna verdadeiro se houver um caminho de origem 'para afundar' t 'no gráfico residual.
    Também preenche o pai [] para armazenar o caminho */
    static boolean bfs(int[][] Graph_r, int s, int t, int[] pai) {

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
}
