package com.example

class manager {
    fun proc(d: List<String>) {
        for (s in d) {
            if (s.length > 5) {
                println(s)
            }
        }
    }

    fun calc(a: Int, b: Int): Int {
        return a + b
    }
}
