## Gaia Project

### Class
* Hex
|DataMenber|Discription|
|----------|-----------|
|int x, y, z| Indicate this hex position in current tile|
|Tile tile | A reference to the tile it belongs to|

|Method|Discription|
|----------|-----------|
|getTile| Get the current tile this Hex belongs to|
|getPos| Get the current position that this Hex in tile|


* Tile

|DataMenber|Discription|
|----------|-----------|
|int x, y, z| Indicate this tile position in current board|
|ArrayList<Hex[]> hexes | An list of hexes that belongs to this tile|

|Method|Discription|
|----------|-----------|
|posGenerator| Generate a layer of position to origin with given distance|
|getPos| Get the current position that Hex in the board|
|getCenterHexGlobalPosInHex|Get this tile's origin hex's board position|


* Board

|DataMenber|Discription|
|----------|-----------|
|private ArrayList<Tile[]> tiles|List of tiles that belongs to this board|

|Method|Discription|
|----------|-----------|
|distance  | get the distance between two hexes|
|distanceInTile | get the distance between two tiles|