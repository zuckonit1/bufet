package com.zuckonit.bufet.stores

case class Desc(
                  id : Int,
                  number: Int,
                  places: Int,
                  bufet: Option[Bufet] = None
                ) extends Named {
  override def name: String = s"${bufet.getOrElse("").asInstanceOf[Bufet].title}"
}

trait DescsStore extends NamedStore[Desc]