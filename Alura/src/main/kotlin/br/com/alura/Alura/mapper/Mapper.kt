package br.com.alura.Alura.mapper

interface Mapper<T, U> {

    fun map(t: T) : U
}