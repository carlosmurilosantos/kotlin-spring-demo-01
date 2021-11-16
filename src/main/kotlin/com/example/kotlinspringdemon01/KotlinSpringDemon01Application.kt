package com.example.kotlinspringdemon01

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*

val animais = mutableListOf<Animal>()

@SpringBootApplication
class KotlinSpringDemon01Application

fun main(args: Array<String>) {
	//animais.add(Animal("Rex", Especie.CACHORRO, 10.5))
	runApplication<KotlinSpringDemon01Application>(*args)
}

@RestController
@RequestMapping("hello")
class HelloWorldController{

	@GetMapping
	fun hello(): String{
		return "hello world!"
	}
	@GetMapping("2")
	fun helloworld2(): String{
		return "Ola mundo!"
	}
}
enum class Especie { CACHORRO, GATO, PASSARO}

data class Animal(val nome: String, val especie: Especie, val peso: Double)



@RestController
@RequestMapping("animais")
class AnimalController {

	@GetMapping
	fun index() = animais

	@PostMapping
	fun create(@RequestBody animal: Animal): Animal {
		animais.add(animal)
		return animal
	}
}