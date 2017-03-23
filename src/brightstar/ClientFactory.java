
package brightstar;

import java.util.ArrayList;
import java.util.Random;

public class ClientFactory {
    
    public static ArrayList<MeshClient> generateClients(int clientcount, int gridsize){
        
        int i = 0;
        Random rgen = new Random();
        ArrayList<MeshClient> meshClients = new ArrayList<>(clientcount);
        while(i < clientcount){
            int xCoord = rgen.nextInt(gridsize);
            int yCoord = rgen.nextInt(gridsize);
            MeshClient a = new MeshClient(xCoord,yCoord);
            meshClients.add(a);
            i++;
        }
        return meshClients;        
    }
}
