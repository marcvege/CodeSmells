class Board {
    private val _plays: MutableList<Tile> = ArrayList<Tile>()

    init {
        for (i in 0..2) {
            for (j in 0..2) {
                val tile = Tile()
                tile.x = i
                tile.y = j
                tile.symbol = ' '
                _plays.add(tile)
            }
        }
    }

    fun tileAt(x: Int, y: Int): Tile? {
        for (t in _plays) {
            if (t.x == x && t.y == y) {
                return t
            }
        }
        return null
    }

    fun addTileAt(symbol: Char, x: Int, y: Int) {
        val newTile = Tile()
        newTile.x = x
        newTile.y = y
        newTile.symbol = symbol
        tileAt(x, y)!!.symbol = symbol
    }
}