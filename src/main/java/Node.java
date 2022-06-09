import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node> {
    private static int idCounter = 0;
    public int id;
    public Node parent = null;
    public List<Edge> neighbors;
    public int f = Integer.MAX_VALUE;
    public int g = Integer.MAX_VALUE;
    public int h;

    Node(int h) {
        this.h = h;
        this.id = idCounter++;
        this.neighbors = new ArrayList<>();
    }

    @Override
    public int compareTo(Node n) {
        return Integer.compare(this.f, n.f);
    }

    public static class Edge {
        Edge(int weight, Node node) {
            this.weight = weight;
            this.node = node;
        }

        public int weight;
        public Node node;
    }

    public void addBranch(int weight, Node node) {
        Edge newEdge = new Edge(weight, node);
        neighbors.add(newEdge);
    }

    public static Node[] createGraph(int[] in) {
        Node[] arr = new Node[16];
        int h = 0;
        for (int i = 0; i < 16; i++) {
            h = 6 - (i % 4 + i / 4);
            arr[i] = new Node(h);
        }
        arr[0].g = 0;
        arr[0].addBranch(in[1], arr[1]);
        arr[0].addBranch(in[4], arr[4]);
//        arr[1].addBranch(in[0], arr[0]);
        arr[1].addBranch(in[5], arr[5]);
        arr[1].addBranch(in[2], arr[2]);
//        arr[2].addBranch(in[1], arr[1]);
        arr[2].addBranch(in[6], arr[6]);
        arr[2].addBranch(in[3], arr[3]);
//        arr[3].addBranch(in[2], arr[2]);
        arr[3].addBranch(in[7], arr[7]);
//        arr[4].addBranch(in[0], arr[0]);
        arr[4].addBranch(in[5], arr[5]);
        arr[4].addBranch(in[8], arr[8]);
//        arr[5].addBranch(in[1], arr[1]);
//        arr[5].addBranch(in[4], arr[4]);
        arr[5].addBranch(in[6], arr[6]);
        arr[5].addBranch(in[9], arr[9]);
//        arr[6].addBranch(in[2], arr[2]);
//        arr[6].addBranch(in[5], arr[5]);
        arr[6].addBranch(in[7], arr[7]);
        arr[6].addBranch(in[10], arr[10]);
//        arr[7].addBranch(in[6], arr[6]);
//        arr[7].addBranch(in[3], arr[3]);
        arr[7].addBranch(in[11], arr[11]);
//        arr[8].addBranch(in[4], arr[4]);
        arr[8].addBranch(in[9], arr[9]);
        arr[8].addBranch(in[12], arr[12]);
//        arr[9].addBranch(in[5], arr[5]);
//        arr[9].addBranch(in[8], arr[8]);
        arr[9].addBranch(in[10], arr[10]);
        arr[9].addBranch(in[13], arr[13]);
//        arr[10].addBranch(in[6], arr[6]);
//        arr[10].addBranch(in[9], arr[9]);
        arr[10].addBranch(in[11], arr[11]);
        arr[10].addBranch(in[14], arr[14]);
//        arr[11].addBranch(in[7], arr[7]);
//        arr[11].addBranch(in[10], arr[10]);
        arr[11].addBranch(in[15], arr[15]);
//        arr[12].addBranch(in[8], arr[8]);
        arr[12].addBranch(in[13], arr[13]);
//        arr[13].addBranch(in[9], arr[9]);
//        arr[13].addBranch(in[12], arr[12]);
        arr[13].addBranch(in[14], arr[14]);
//        arr[14].addBranch(in[10], arr[10]);
//        arr[14].addBranch(in[13], arr[13]);
        arr[14].addBranch(in[15], arr[15]);
//        arr[15].addBranch(in[11], arr[11]);
//        arr[15].addBranch(in[14], arr[14]);
        return arr;
    }
}
