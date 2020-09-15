package tree.graph;

public class GoogleInterveiwSoln {
    CityNode root;

    public GoogleInterveiwSoln(String name, int population){
        this.root = new CityNode(name, population);
    }

    class CityNode {
        private final String name;
        private final int population;
        CityNode left, right;

        public CityNode(String name, int val){
            this.name=name;
            this.population=val;
            left=null;
            right=null;
        }
        String getName(){
            return this.name;
        }

        int getPopulation(){
            return this.population;
        }
    }


    public void addEdge(CityNode source, int population, String where, String name){
        CityNode dest = new CityNode(name, population);
        if(where.equals("right"))
            source.right= dest;
        else
            source.left=dest;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("root: ").append(root.name).append(" left: ").append(root.left.name).append(" right: ").append(root.right.name);
        return sb.toString();
    }

    public void printCities(CityNode root, String prefix){
        if(root!=null){
            int temp;
            if(prefix.equals(""))
                temp=0;
            else
                temp= root.getName().substring(0, prefix.length()).compareTo(prefix);

            if(temp>0) {
                printCities(root.left, prefix);
            }
            else if(temp==0){
                printCities(root.left, prefix);
                System.out.println(root.getName()+ " "+ root.getPopulation());
                printCities(root.right, prefix);
            }
            else{
                printCities(root.right, prefix);
            }
        }
    }

    public static void main(String [] args){
        GoogleInterveiwSoln tree = new GoogleInterveiwSoln("phili", 9);
        tree.addEdge(tree.root, 4, "right", "Atlanta");
        tree.addEdge(tree.root,11, "left", "New York");
        tree.addEdge(tree.root.left,10, "right", "New England");
        tree.addEdge(tree.root.left,15, "left", "New Hampshire");
        tree.printCities(tree.root, "New");
    }

}
