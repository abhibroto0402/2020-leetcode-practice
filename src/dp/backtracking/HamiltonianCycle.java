package dp.backtracking;

public class HamiltonianCycle {
    private final int numOfVertexes;
    private final int[] hamiltonianPath;
    private final int[][] adj;

    HamiltonianCycle(int [] [] adj){
        this.adj=adj;
        this.numOfVertexes=adj.length;
        this.hamiltonianPath= new int[numOfVertexes];
        this.hamiltonianPath[0]=0;

    }

    public void solve (){
        if(feasibleSolution(1)){
            showHamiltonian();
        }else{
            System.out.println("no solution");
        }
    }
    private boolean feasibleSolution(int position) {
        if(position==numOfVertexes)
            return adj[hamiltonianPath[position-1]][hamiltonianPath[0]]==1;
        for(int vertexIndex=1; vertexIndex<numOfVertexes;++vertexIndex){
            if(isValid(vertexIndex, position)){
                hamiltonianPath[position]=vertexIndex;
                if(feasibleSolution(position+1)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int vertexIndex, int actualPosition) {
        if(adj[hamiltonianPath[actualPosition-1]][vertexIndex]==0) return false;
        for(int i=0; i<actualPosition;++i)
            if(hamiltonianPath[i]==vertexIndex) return false;
        return true;

    }

    private void showHamiltonian() {
        for(int i=0; i<numOfVertexes;i++){
            System.out.print(hamiltonianPath[i]+" ");
        }
        System.out.print(hamiltonianPath[0]);
    }

    public static void main(String[] args) {
        int [] [] matrix = {
                {0,1,1,1,0,0},
                {1,0,1,0,1,0},
                {1,1,1,1,0,1},
                {1,0,1,0,0,1},
                {0,1,0,0,0,1},
                {0,1,1,1,1,1},
        };
        HamiltonianCycle cycle = new HamiltonianCycle(matrix);
        cycle.solve();

    }
}
