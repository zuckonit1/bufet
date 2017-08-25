package com.zuckonit.bufet.stores

case class Dish(
                  id : Int,
                  title: String,
                  //todo enviroment variables object
                  logo: String = "default",
                  logoFull: String = "default",
                  price: Double,
                  weigth: Option[Double] = None,
                  units: String,
                  caloricity : Int,
                  bufets : Option[Array[Bufet]] = None,
                  products : Option[Array[Products]] = None
                ) extends Named {
  override def name: String = title
}

trait DishesStore extends NamedStore[Dish]