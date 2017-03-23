
package brightstar;

import java.util.ArrayList;

public class MeshSupport {
    
    public static double euclidean(MeshNode n, MeshClient c){
        double x = n.getxCoord()- c.getxCoord();
        double y = n.getyCoord() - c.getyCoord();
        x = x * x;
        y = y * y;
        double distance = Math.sqrt(x + y);
        return distance;
    }
    
    public static double euclideanCenter(double x, double y, MeshClient c){
        double x2 = x - c.getxCoord();
        double y2 = y - c.getyCoord();
        x2 = x2 * x2;
        y2 = y2 * y2;
        double distance = Math.sqrt(x2 + y2);
        return distance;
    }
    
    public static double[] getClientCenter(ArrayList<MeshClient> clients){
        double[] coord = new double[2];
        int x = 0;
        int y = 0;
        for(MeshClient c: clients){
            x = x + c.getxCoord();
            y = y + c.getyCoord();
        }
        coord[0]= x / clients.size();
        coord[1]= y / clients.size();
        
        return coord;
        
    }
    
    public static double[] getClientOutlier(ArrayList<MeshClient> clients){
        
        double[] centerCoords = getClientCenter(clients);
        double centerX = centerCoords[0];
        double centerY = centerCoords[1];
        double[] maxCoords = new double[2];
        
        double maxDistance = 0;
        double distance = 0;
        
        for(MeshClient c: clients){
            distance = euclideanCenter(centerX, centerY,c);
            if(distance > maxDistance){
                maxCoords[0] = c.getxCoord();
                maxCoords[1] = c.getyCoord();
                maxDistance = distance;
            }            
        }
        return maxCoords;
    }
    public static double[] getClosestClient(ArrayList<MeshClient> clients){
        
        double[] centerCoords = getClientCenter(clients);
        double centerX = centerCoords[0];
        double centerY = centerCoords[1];
        double[] minCoords = new double[2];
        
        double minDistance = 10000000;
        double distance = 0;
        
        for(MeshClient c: clients){
            distance = euclideanCenter(centerX, centerY,c);
            if(distance < minDistance){
                minCoords[0] = c.getxCoord();
                minCoords[1] = c.getyCoord();
                minDistance = distance;
            }            
        }
        return minCoords;
    }
    
}
