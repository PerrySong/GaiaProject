import java.util.ArrayList;

public class Tile {

    private ArrayList<Hex[]> hexes;
    private int x;
    private int y;
    private int z;

    /**
     * A Tile has x y z that indicates its position in the board, and has 19 hexes
     * @param xyz
     */
    public Tile(int[] xyz) {
        this.x = xyz[0];
        this.y = xyz[1];
        this.z = xyz[2];

        Hex[] center = new Hex[1];
        Hex[] secondLayer = new Hex[2];
        Hex[] thirdLayer = new Hex[3];
        hexes.add(center);
        hexes.add(secondLayer);
        hexes.add(thirdLayer);

        // distance represents the distance between current position to center
        int distance = 0;
        for (Hex[] layer : hexes) {
            ArrayList<int[]> positions = posGenerator(-distance, distance, distance);
            int iLayer = 0;
            for (int[] pos : positions) {
                layer[iLayer++] = new Hex(pos, this);
            }
            distance++;
        }

    }

    /**
     * Generate a layer of position to origin with given distance
     * @param lowerBound
     * @param upperBound
     * @param distance
     * @return An list of position that has certain distance to this tile's origin hex
     */

    public ArrayList<int[]> posGenerator(int lowerBound, int upperBound, int distance) {
        ArrayList<int[]> res = new ArrayList<>();
        for (int x = lowerBound; x <= upperBound; x++) {
            for (int y = lowerBound; y <= upperBound; y++) {
                for (int z = lowerBound; z <= upperBound; z++) {
                    if (Math.abs(x) + Math.abs(y) + Math.abs(z) == distance)
                        res.add(new int[] {x, y, z});
                }
            }
        }
        return res;
    }

    /**
     * Get the current Tile position in the board
     * @return position
     */
    public int[] getPos() {
        return new int[]{x, y, z};
    }

    /**
     * Get this tile's origin hex's board position
     * @return origin board position
     */
    public int[] getCenterHexGlobalPosInHex() {
        int[] pos = this.getPos();
        for (int i = 0; i < 3; i++) {
            pos[i] *= 5;
        }
        return pos;
    }

}
