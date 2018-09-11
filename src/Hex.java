public class Hex {
    // Store hex's local position in tile
    private int x;
    private int y;
    private int z;

    private Tile tile; // Hex belongs to this tile

    public Hex(int x, int y, int z, Tile tile) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.tile = tile;
    }

    public Hex(int[] xyz, Tile tile) {
        this.x = xyz[0];
        this.y = xyz[1];
        this.z = xyz[2];
        this.tile = tile;
    }

    /**
     *
     * @return the current tile this Hex belongs to
     */
    public Tile getItsTile() {
        return tile;
    }

    /**
     * Get the current position that Hex in this tile
     * @return position
     */
    public int[] getPos() {
        return new int[]{x, y, z};
    }
}
