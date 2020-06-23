class Node {
    Node right, left;
    int val;
    Node(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return val + " \nleft -> "+ this.left + " \nright -> " + this.right;
    }
}
