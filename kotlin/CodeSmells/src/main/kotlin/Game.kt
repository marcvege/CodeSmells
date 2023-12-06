class Game {
    private var _lastSymbol = ' '
    private val _board: Board = Board()

    fun play(symbol: Char, x: Int, y: Int) {
        //if first move
        if (_lastSymbol == ' ') {
            //if player is X
            if (symbol == 'O') {
                throw Exception("Invalid first player")
            }
        } else if (symbol == _lastSymbol) {
            throw Exception("Invalid next player")
        } else if (_board.tileAt(x, y)!!.symbol != ' ') {
            throw Exception("Invalid position")
        }

        // update game state
        _lastSymbol = symbol
        _board.addTileAt(symbol, x, y)
    }

    fun winner(): Char {
        //if the positions in first row are taken
        if (_board.tileAt(0, 0)!!.symbol != ' ' &&
            _board.tileAt(0, 1)!!.symbol != ' ' &&
            _board.tileAt(0, 2)!!.symbol != ' '
        ) {
            //if first row is full with same symbol
            if (_board.tileAt(0, 0)!!.symbol == _board.tileAt(0, 1)!!.symbol &&
                _board.tileAt(0, 2)!!.symbol == _board.tileAt(0, 1)!!.symbol
            ) {
                return _board.tileAt(0, 0)!!.symbol!!
            }
        }

        //if the positions in first row are taken
        if (_board.tileAt(1, 0)!!.symbol != ' ' &&
            _board.tileAt(1, 1)!!.symbol != ' ' &&
            _board.tileAt(1, 2)!!.symbol != ' '
        ) {
            //if middle row is full with same symbol
            if (_board.tileAt(1, 0)!!.symbol == _board.tileAt(1, 1)!!.symbol &&
                _board.tileAt(1, 2)!!.symbol == _board.tileAt(1, 1)!!.symbol
            ) {
                return _board.tileAt(1, 0)!!.symbol!!
            }
        }

        //if the positions in first row are taken
        if (_board.tileAt(2, 0)!!.symbol != ' ' &&
            _board.tileAt(2, 1)!!.symbol != ' ' &&
            _board.tileAt(2, 2)!!.symbol != ' '
        ) {
            //if middle row is full with same symbol
            if (_board.tileAt(2, 0)!!.symbol == _board.tileAt(2, 1)!!.symbol &&
                _board.tileAt(2, 2)!!.symbol == _board.tileAt(2, 1)!!.symbol
            ) {
                return _board.tileAt(2, 0)!!.symbol!!
            }
        }
        return ' '
    }
}
