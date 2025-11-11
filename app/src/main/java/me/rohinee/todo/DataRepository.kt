package me.rohinee.todo

import javax.inject.Inject

class DataRepository @Inject constructor() {
    fun getData(): String {
        return "Hello from DataRepository"
    }
}