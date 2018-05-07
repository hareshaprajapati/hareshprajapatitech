package The8puzzle;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solver {
    //public Solver(Board initial)            // find a solution to the initial board (using the A* algorithm)
    //public boolean isSolvable()             // is the initial board solvable?
    //public int moves()                      // min number of moves to solve initial board; -1 if no solution
    //public Iterable<Board> solution()       // sequence of boards in a shortest solution; null if no solution
    //public static void main(String[] args)  // solve a slider puzzle (given below)
    // you will want to use comparator for hamming & man
    //MinPq<node> pq as the priority queue

    private Node goalNode;
    private Queue<Node> pq = new LinkedList<>();
    private Queue<Node> pqTwin = new LinkedList<Node>();

    public class Node
//            implements Comparable<Node>
    {
        public Board board;
        public Node previous;
        public int moves;

        /*public int compareTo(Node that){
            //StdOut.println("i:" + this.priority() + " j:" + that.priority() + " "+ ((this.priority() > that.priority()) ? 1 :  -1));
            if(this.priority() == that.priority()) return 0;
            return (this.priority() > that.priority()) ? 1 :  -1;
        }*/

        public Node(Board b, Node prev, int m){
            board = b;
            previous = prev;
            moves = m;
        }

       /* public int priority(){
            return board.manhattan() + moves;
        }*/
    }

    public Solver(Board initial){
        Board initialBoard;
        Queue<Board> neighbors = new LinkedList<>();
        initialBoard = initial;

        Node currentNode = new Node(initial, null, 0);
//        Node currentTwin = new Node(initial.twin(), null, 0);
        pq.add(currentNode);
//        pqTwin.add(currentTwin);

        while(!currentNode.board.isGoal() /*&& !currentTwin.board.isGoal()*/){

            currentNode = pq.poll();
//            currentTwin = pqTwin.poll();

            for(Board b : currentNode.board.neighbors()) {
                if(!b.equals(currentNode.board))
                    pq.add(new Node(b, currentNode, currentNode.moves +1));
            }

            /*for(Board b : currentTwin.board.neighbors()) {
                if(!b.equals(currentNode.board))
                    pqTwin.add(new Node(b, currentTwin, currentTwin.moves +1));
            }*/
        }

        if(currentNode.board.isGoal())
            goalNode = currentNode;
        else{
//            goalNode = currentTwin;
            System.out.println("setting twin as goal");
        }

    }

    public Stack<Board> solution(){
        Stack<Board> trace = new Stack<>();
        trace.push(goalNode.board);
        while (goalNode.previous != null){
            goalNode = goalNode.previous;
            trace.push(goalNode.board);
        }

        return trace;
    }

    public boolean isSolvable(){
        return goalNode != null;
    }

    public int moves(){
        return goalNode.moves;
    }

    public static void main(String[] args) {
        // create initial board from file
        int[][] blocks = {
               /* {1 ,2 ,3},
                {4 ,0 ,6},
                {7 ,8, 5}*/

                {4,  1  ,3},
                {0  ,2  ,5},
                {7  ,8  ,6}
        };
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);


        // print solution to standard output
        if (!solver.isSolvable())
            System.out.println("No solution possible");
        else {
            System.out.println("Minimum number of moves = " + solver.moves());
            Stack<Board> solution = solver.solution();
            while (!solution.empty()){
                System.out.println(solution.pop());
            }

        }
    }
}