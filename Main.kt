package tictactoe

fun main() {
    val hor1 = mutableListOf('|', ' ', ' ', ' ', '|')
    val hor2 = mutableListOf('|', ' ', ' ', ' ', '|')
    val hor3 = mutableListOf('|', ' ', ' ', ' ', '|')
    val grid = mutableListOf(
        hor1,
        hor2,
        hor3
    )
    var move = "0 0".split(" ")
    fun grid() {
        println("---------")
        for (i in 0 until grid.size) {
            println(grid[i].joinToString(" "))
        }
        println("---------")
    }
    grid()
    var endGame = false
    loop@ while (' ' in hor1 || ' ' in hor2 || ' ' in hor3) {
        move = readln().split(" ")
        fun checkX() {
            var checkX = true
            while (checkX) {
                if (move[0] !in "0".."9" && move[1] !in "0".."9") {
                    println("You should enter numbers!")
                    move = readln().split(" ")
                } else if ((move[0] !in "1".."3" || move[1] !in "1".."3") && move[0] in "0".."9" && move[1] in "0".."9") {
                    println("Coordinates should be from 1 to 3!")
                    move = readln().split(" ")
                } else if (move[0] in "1".."3" && move[1] in "1".."3") {
                    if (grid[move[0].toInt() - 1][move[1].toInt()] == 'X' || grid[move[0].toInt() - 1][move[1].toInt()] == 'O') {
                        println("This cell is occupied! Choose another one!")
                        move = readln().split(" ")
                    } else checkX = false
                }
            }
        }
        checkX()
        fun moveX() {
            val hor = move[0].toInt()
            val ver = move[1].toInt()
            grid[hor - 1].add(ver, 'X')
            grid[hor - 1].removeAt(ver + 1)
            println("---------")
            for (i in 0 until grid.size) {
                println(grid[i].joinToString(" "))
            }
            println("---------")
        }
        moveX()
        fun possibilityX() {
            var x = 0
            var o = 0
            val str = mutableListOf(hor1[1], hor1[2], hor1[3], hor2[1], hor2[2], hor2[3], hor3[1], hor3[2], hor3[3]).joinToString("")
            for (i in 0..8) {
                if (str[i] == 'X') {
                    x += 1
                } else if (str[i] == 'O') {
                    o += 1
                }
            }
            if (((str[0] == 'X' && str[1] == 'X' && str[2] == 'X') || (str[3] == 'X' && str[4] == 'X' && str[5] == 'X') || (str[6] == 'X' && str[7] == 'X' && str[8] == 'X') || (str[0] == 'X' && str[4] == 'X' && str[8] == 'X') || (str[2] == 'X' && str[4] == 'X' && str[6] == 'X') || (str[0] == 'X' && str[3] == 'X' && str[6] == 'X') || (str[1] == 'X' && str[4] == 'X' && str[7] == 'X') || (str[2] == 'X' && str[5] == 'X' && str[8] == 'X')) && ((str[0] == 'O' && str[1] == 'O' && str[2] == 'O') || (str[3] == 'O' && str[4] == 'O' && str[5] == 'O') || (str[6] == 'O' && str[7] == 'O' && str[8] == 'O') || (str[0] == 'O' && str[4] == 'O' && str[8] == 'O') || (str[2] == 'O' && str[4] == 'O' && str[6] == 'O') || (str[0] == 'O' && str[3] == 'O' && str[6] == 'O') || (str[1] == 'O' && str[4] == 'O' && str[7] == 'O') || (str[2] == 'O' && str[5] == 'O' && str[8] == 'O'))) {
                println("Impossible")
                endGame = true
            } else if (x - o >= 2 || o - x >= 2) {
                println("Impossible")
                endGame = true
            } else if ((str[0] == 'X' && str[1] == 'X' && str[2] == 'X') || (str[3] == 'X' && str[4] == 'X' && str[5] == 'X') || (str[6] == 'X' && str[7] == 'X' && str[8] == 'X') || (str[0] == 'X' && str[4] == 'X' && str[8] == 'X') || (str[2] == 'X' && str[4] == 'X' && str[6] == 'X') || (str[0] == 'X' && str[3] == 'X' && str[6] == 'X') || (str[1] == 'X' && str[4] == 'X' && str[7] == 'X') || (str[2] == 'X' && str[5] == 'X' && str[8] == 'X')) {
                println("X wins")
                endGame = true
            } else if ((str[0] == 'O' && str[1] == 'O' && str[2] == 'O') || (str[3] == 'O' && str[4] == 'O' && str[5] == 'O') || (str[6] == 'O' && str[7] == 'O' && str[8] == 'O') || (str[0] == 'O' && str[4] == 'O' && str[8] == 'O') || (str[2] == 'O' && str[4] == 'O' && str[6] == 'O') || (str[0] == 'O' && str[3] == 'O' && str[6] == 'O') || (str[1] == 'O' && str[4] == 'O' && str[7] == 'O') || (str[2] == 'O' && str[5] == 'O' && str[8] == 'O')) {
                println("O wins")
                endGame = true
            } else if ((str[0] == '_') || (str[1] == '_') || (str[2] == '_') || (str[3] == '_') || (str[4] == '_') || (str[5] == '_') || (str[6] == '_') || (str[7] == '_') || (str[8] == '_')) {
                println("Game not finished")
                endGame = true
            } else if (' ' !in str) {
                println("Draw")
                endGame = true
            }
        }
        possibilityX()
        if (endGame) {
            break@loop
        }
        move = readln().split(" ")
        fun checkO() {
            var checkO = true
            while (checkO) {
                if (move[0] !in "0".."9" && move[1] !in "0".."9") {
                    println("You should enter numbers!")
                    move = readln().split(" ")
                } else if ((move[0] !in "1".."3" || move[1] !in "1".."3") && move[0] in "0".."9" && move[1] in "0".."9") {
                    println("Coordinates should be from 1 to 3!")
                    move = readln().split(" ")
                } else if (move[0] in "1".."3" && move[1] in "1".."3") {
                    if (grid[move[0].toInt() - 1][move[1].toInt()] == 'X' || grid[move[0].toInt() - 1][move[1].toInt()] == 'O') {
                        println("This cell is occupied! Choose another one!")
                        move = readln().split(" ")
                    } else checkO = false
                }
            }
        }
        checkO()
        fun moveO() {
            val hor = move[0].toInt()
            val ver = move[1].toInt()
            grid[hor - 1].add(ver, 'O')
            grid[hor - 1].removeAt(ver + 1)
            println("---------")
            for (i in 0 until grid.size) {
                println(grid[i].joinToString(" "))
            }
            println("---------")
        }
        moveO()
        fun possibilityO() {
            var x = 0
            var o = 0
            val str = mutableListOf(hor1[1], hor1[2], hor1[3], hor2[1], hor2[2], hor2[3], hor3[1], hor3[2], hor3[3]).joinToString("")
            for (i in 0..8) {
                if (str[i] == 'X') {
                    x += 1
                } else if (str[i] == 'O') {
                    o += 1
                }
            }
            if (((str[0] == 'X' && str[1] == 'X' && str[2] == 'X') || (str[3] == 'X' && str[4] == 'X' && str[5] == 'X') || (str[6] == 'X' && str[7] == 'X' && str[8] == 'X') || (str[0] == 'X' && str[4] == 'X' && str[8] == 'X') || (str[2] == 'X' && str[4] == 'X' && str[6] == 'X') || (str[0] == 'X' && str[3] == 'X' && str[6] == 'X') || (str[1] == 'X' && str[4] == 'X' && str[7] == 'X') || (str[2] == 'X' && str[5] == 'X' && str[8] == 'X')) && ((str[0] == 'O' && str[1] == 'O' && str[2] == 'O') || (str[3] == 'O' && str[4] == 'O' && str[5] == 'O') || (str[6] == 'O' && str[7] == 'O' && str[8] == 'O') || (str[0] == 'O' && str[4] == 'O' && str[8] == 'O') || (str[2] == 'O' && str[4] == 'O' && str[6] == 'O') || (str[0] == 'O' && str[3] == 'O' && str[6] == 'O') || (str[1] == 'O' && str[4] == 'O' && str[7] == 'O') || (str[2] == 'O' && str[5] == 'O' && str[8] == 'O'))) {
                println("Impossible")
                endGame = true
            } else if (x - o >= 2 || o - x >= 2) {
                println("Impossible")
                endGame = true
            } else if ((str[0] == 'X' && str[1] == 'X' && str[2] == 'X') || (str[3] == 'X' && str[4] == 'X' && str[5] == 'X') || (str[6] == 'X' && str[7] == 'X' && str[8] == 'X') || (str[0] == 'X' && str[4] == 'X' && str[8] == 'X') || (str[2] == 'X' && str[4] == 'X' && str[6] == 'X') || (str[0] == 'X' && str[3] == 'X' && str[6] == 'X') || (str[1] == 'X' && str[4] == 'X' && str[7] == 'X') || (str[2] == 'X' && str[5] == 'X' && str[8] == 'X')) {
                println("X wins")
                endGame = true
            } else if ((str[0] == 'O' && str[1] == 'O' && str[2] == 'O') || (str[3] == 'O' && str[4] == 'O' && str[5] == 'O') || (str[6] == 'O' && str[7] == 'O' && str[8] == 'O') || (str[0] == 'O' && str[4] == 'O' && str[8] == 'O') || (str[2] == 'O' && str[4] == 'O' && str[6] == 'O') || (str[0] == 'O' && str[3] == 'O' && str[6] == 'O') || (str[1] == 'O' && str[4] == 'O' && str[7] == 'O') || (str[2] == 'O' && str[5] == 'O' && str[8] == 'O')) {
                println("O wins")
                endGame = true
            } else if ((str[0] == '_') || (str[1] == '_') || (str[2] == '_') || (str[3] == '_') || (str[4] == '_') || (str[5] == '_') || (str[6] == '_') || (str[7] == '_') || (str[8] == '_')) {
                println("Game not finished")
                endGame = true
            } else if (' ' !in str) {
                println("Draw")
                endGame = true
            }
        }
        possibilityO()
        if (endGame) {
            break@loop
        }
    }
}