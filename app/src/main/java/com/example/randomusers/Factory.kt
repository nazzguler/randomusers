package com.example.randomusers

interface Factory<T> {
    fun create(): T
}