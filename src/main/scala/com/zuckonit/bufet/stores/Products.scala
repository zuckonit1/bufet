package com.zuckonit.bufet.stores

case class Products(
                 id : Int,
                 title: String,
                 bufets: Option[Array[Bufet]] = None,
                 dishes: Option[Array[Dish]] = None
               ) extends Named {
  override def name: String = title
}
trait ProductsStore extends NamedStore[Product] {
  def load( id : Int ): Product = load(id)
}
