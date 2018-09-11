import java.util.ArrayList;

public class Board {

    private ArrayList<Tile[]> tiles;


    public Board() {
        Tile[] center = new Tile[1];
        Tile[] secondLayer = new Tile[2];
        Tile[] thirdLayer = new Tile[3];
        tiles.add(center);
        tiles.add(secondLayer);
        tiles.add(thirdLayer);

        // distance represents the distance between current position to center
        int distance = 0;
        for (Tile[] layer : tiles) {
            ArrayList<int[]> positions = posGenerator(-distance, distance, distance);
            int iLayer = 0;
            for (int[] pos : positions) {
                layer[iLayer++] = new Tile(pos);
            }
            distance++;
        }

    }

    /**
     *
     * @param lowerBound
     * @param upperBound
     * @param distance
     * @return
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
     *
     * @param tile1
     * @param tile2
     * @return
     */
    public int distanceInTiles(Tile tile1, Tile tile2) {
        int[] pos1 = tile1.getPos();
        int[] pos2 = tile2.getPos();
        return distance(pos1, pos2);
    }

    /**
     *
     * @param tile1
     * @param tile2
     * @return
     */
    public int[] vectorInTile(Tile tile1, Tile tile2) {
        int[] pos1 = tile1.getPos();
        int[] pos2 = tile2.getPos();
        int[] res = new int[3];
        for (int i = 0; i < 3; i++) {
            res[i] = Math.abs(pos1[i] - pos2[i]);
        }
        return res;
    }

    /**
     *
     * @param hex1
     * @param hex2
     * @return
     */
    public int distanceInHexs(Hex hex1, Hex hex2) {
        // hex1 -> hex2 vector

        int[] posHex1Center = hex1.getItsTile().getCenterHexGlobalPosInHex();
        int[] posHex2Center = hex2.getItsTile().getCenterHexGlobalPosInHex();

        return distance(posHex1Center, posHex2Center) + distance(hex1.getPos(), hex2.getPos());
    }

    public int distance(int[] pos1, int[] pos2) {
        int res = 0;
        for (int i = 0; i < 3; i++) {
            res += Math.abs(pos1[i] - pos2[i]);
        }
        return res;
    }
}
