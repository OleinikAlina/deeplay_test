import java.util.PriorityQueue;

public class AStar {
    public static int aStar(Node start, Node target) {
        PriorityQueue<Node> closedList = new PriorityQueue<>();
        PriorityQueue<Node> openList = new PriorityQueue<>();
//        start.f = start.g + start.calculateHeuristic(target);
        start.f = start.g + start.h;
        openList.add(start);

        while (!openList.isEmpty()) {
            Node n = openList.peek();
            if (n == target) {
                return n.g;
            }
            for (Node.Edge edge : n.neighbors) {
                Node m = edge.node;
                int totalWeight = n.g + edge.weight;

                if (!openList.contains(m) && !closedList.contains(m)) {
                    m.parent = n;
                    m.g = totalWeight;
//                    m.f = m.g + m.calculateHeuristic(target);
                    m.f = m.g + m.h;
                    openList.add(m);
                } else {
                    if (totalWeight < m.g) {
                        m.parent = n;
                        m.g = totalWeight;
//                        m.f = m.g + m.calculateHeuristic(target);
                        m.f = m.g + m.h;
                        if (closedList.contains(m)) {
                            closedList.remove(m);
                            openList.add(m);
                        }
                    }
                }
            }

            openList.remove(n);
            closedList.add(n);
        }
        return -1;
    }
}
