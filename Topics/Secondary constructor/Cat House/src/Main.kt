class Kitty {
    val color: String
    var age: Int

    constructor(color: String) {
        this.color = color
        this.age = 0
    }
    constructor(age: Int) {
        this.color = ""
        this.age = age
    }
    constructor(color: String, age: Int) {
        this.color = color
        this.age = age
    }
    constructor(color: String, age: Float) {
        this.color = color
        this.age = age.toInt()
    }
    constructor(color: String, age: Double) {
        this.color = color
        this.age = age.toInt()
    }
    constructor(color: String, age: String) {
        this.color = color
        this.age = age.toInt()
    }
    constructor(age: Int, color: String) {
        this.color = color
        this.age = age
    }
    constructor(age: Float, color: String) {
        this.color = color
        this.age = age.toInt()
    }
    constructor(age: Double, color: String) {
        this.color = color
        this.age = age.toInt()
    }
}