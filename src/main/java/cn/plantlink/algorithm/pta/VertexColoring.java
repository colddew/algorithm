package cn.plantlink.algorithm.pta;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 若一个图最少需要m种颜色才能使图中任意相邻的2个顶点着不同颜色
 */
public class VertexColoring {

    public static void main(String[] args) throws Exception {

        Edge[] edges = new Edge[10010];
        int[] colors = new int[10010];

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        for (int i = 0; i < m; i++) {
            Edge edge = new Edge();
            edge.left = scan.nextInt();
            edge.right = scan.nextInt();
            edges[i] = edge;
        }

        int k = scan.nextInt();

        Set set = new HashSet();
        for (int j = 0; j < k; j++) {

            set.clear();
            for (int i = 0; i < n; i++) {
                colors[i] = scan.nextInt();
                set.add(colors[i]);
            }

            boolean same = false;
            for (int i = 0; i < m; i++) {
                int left = colors[edges[i].left];
                int right = colors[edges[i].right];
                if (left == right) {
                    same = true;
                }
            }

            if (same) {
                System.out.println("No");
            } else {
                System.out.println(set.size() + "-coloring");
            }
        }

        scan.close();
    }
}

class Edge {
    public int left;
    public int right;
}