public interface INode {

enum search{
    Node,SearchAlorithm


}


    public String toString( );

    public boolean[] getState();

    public void setState(boolean[] stateSet);

    public void setFatherNode(Node node);

    public Node getFatherNode();

    public boolean equals(Node targetNode);

    public String toString(Node node);

   public Node Clone();
   public static INode creat(search type){
       return new Node();
   }



}
