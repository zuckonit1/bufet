package com.zuckonit.bufet.stores

case class Language(id : Int, shortName : String, fullName : String, enabled : Boolean, major : Boolean) extends Named{
  override def name: String = fullName
}
trait LanguageStore extends NamedStore[Language]
