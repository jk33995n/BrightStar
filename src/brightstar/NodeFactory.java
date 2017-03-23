
package brightstar;

import java.util.ArrayList;
import java.util.Random;

public class NodeFactory {
    
    public static ArrayList<MeshNode> generateNodes(int nodecount, int gridsize){
        
        int i = 0;
        Random rgen = new Random();
        ArrayList<MeshNode> meshnodes = new ArrayList<>(nodecount);
        while(i < nodecount){
            int xCoord = rgen.nextInt(gridsize);
            int yCoord = rgen.nextInt(gridsize);
            ArrayList<MeshClient> n = new ArrayList<>(nodecount);
            MeshNode a = new MeshNode(xCoord,yCoord,n);
            meshnodes.add(a);
            i++;
        }
        return meshnodes;        
    }
    
}
