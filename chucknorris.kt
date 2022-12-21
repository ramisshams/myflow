package chucknorris

fun operation() {
    println("Please input operation (encode/decode/exit):")
    var operation = readln()
    while (operation != "exit") {
        while (operation != "encode" && operation != "decode" && operation != "exit") {
            println("There is no '$operation' operation")
            println("Please input operation (encode/decode/exit):")
            operation = readln()
        }
        when (operation) {
            "encode" -> encode()
            "decode" -> decode()
        }
        println("Please input operation (encode/decode/exit):")
        operation = readln()
    }
    when (operation) {
        "exit" -> println("Bye!")
    }
}
fun encode() {
    println("Input string:")
    val input = readln().toMutableList()
    println("Encoded string:")
    var coded = mutableListOf<String>()
    for (i in 0 until input.size) {
        var code = input[i].code
        var binary = Integer.toBinaryString(code).toInt()
        var formattedBinary = String.format("%07d", binary)
        coded.add(formattedBinary)
    }
    var codedJoint = coded.joinToString("")
    var count = 1
    for (i in 0..codedJoint.length - 2) {
        if (codedJoint[i] != codedJoint[i + 1]) {
            count++
        }
    }
    while (count != 0) {
        if (codedJoint[0] == '1') {
            print("0 ")
            print("0".repeat(codedJoint.substringBefore('0').length))
            print(" ")
            codedJoint = codedJoint.replaceFirst("${codedJoint.substringBefore('0')}", "")
            count--
        } else {
            print("00 ")
            print("0".repeat(codedJoint.substringBefore('1').length))
            print(" ")
            codedJoint = codedJoint.replaceFirst("${codedJoint.substringBefore('1')}", "")
            count--
        }
    }
    println()
}
fun decode() {
    println("Input encoded string:")
    val input = readln().split(" ")
    val codeFinish = mutableListOf<String>()
    var check = false
    for (i in 0 until input.size) {
        for (j in 0 until input[i].length) {
            if (input[i][j] != '0') {
                check = true
            }
        }
    }
    for (i in 0 until input.size step 2) {
        if (input[i] != "0" && input[i] != "00") {
            check = true
        }
    }
    if (input.size % 2 != 0) {
        check = true
    }
    var sum = 0
    for (i in 1 until input.size step 2) {
        sum += input[i].length
    }
    if (sum % 7 != 0) {
        check = true
    }
    if (check) {
        println("Encoded string is not valid.")
    } else {
        println("Decoded string:")
        val codeBinary = mutableListOf<String>()
        for (i in 0 until input.size - 1 step 2) {
            if (input[i] == "0") {
                codeBinary.add("1".repeat(input[i + 1].length))
            } else {
                codeBinary.add("0".repeat(input[i + 1].length))
            }
        }
        val codeJoint = codeBinary.joinToString("")
        var k = 0
        for (j in 0 until codeJoint.length step 7) {
            k = j
            var char = mutableListOf<Char>()
            repeat(7) {
                char.add(codeJoint[k])
                k++
            }
            codeFinish.add(char.joinToString(""))
        }
    }
    for (i in 0 until codeFinish.size) {
        var intCode = Integer.parseInt(codeFinish[i])
        var binary = String.format("%07d", intCode)
        var code = binary[0].toString().toInt() * 64 + binary[1].toString().toInt() * 32 + binary[2].toString()
            .toInt() * 16 + binary[3].toString().toInt() * 8 + binary[4].toString().toInt() * 4 + binary[5].toString()
            .toInt() * 2 + binary[6].toString().toInt() * 1
        print(code.toChar())
    }
    println()
}

fun main() {
    operation()
}

