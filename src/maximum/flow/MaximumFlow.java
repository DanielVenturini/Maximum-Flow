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
public class MaximumFlow {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // RAAAAAAAAAAANNNN PA
        int graph[][] =new int[][] { {0, 16, 13, 0, 0, 0},
                                     {0, 0, 10, 12, 0, 0},
                                     {0, 4, 0, 0, 14, 0},
                                     {0, 0, 9, 0, 0, 20},
                                     {0, 0, 0, 7, 0, 4},
                                     {0, 0, 0, 0, 0, 0}
                                   };
        MaxFlow m = new MaxFlow();
 
        System.out.println("O fluxo maximo do grafo: " + m.fordFulkerson(graph, 0, 5));
 
    }
    
}
