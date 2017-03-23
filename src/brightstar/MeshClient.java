
package brightstar;

public class MeshClient {
    
    private String name;
    private int xCoord;
    private int yCoord;
    public static int clientCount = 0;

    public MeshClient(int xCoord, int yCoord) {
        this.name = "C0-" + clientCount;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        clientCount++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    @Override
    public String toString() {
        return "MeshClient[" + "name = " + name + ", xCoord = " + xCoord + ", yCoord = " + yCoord + "]";
    }
    
    
    
    
    
}
