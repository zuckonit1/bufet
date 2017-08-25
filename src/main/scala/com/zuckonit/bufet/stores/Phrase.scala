package com.zuckonit.bufet.stores

case class Phrase(
                  id : Int,
                  text: String,
                  author: String,
                  orders : Option[Array[Order]] = None
                ) extends Named {
  override def name: String = author
}

trait PhrasesStore extends NamedStore[Phrase]