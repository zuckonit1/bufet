package com.zuckonit.bufet.enums

object ClientType extends Enumeration {
  protected class Type extends Value{
    private var dis = 0
    def this(d : Int) {
      this()
      if(d > 0) dis = d
    }
    def discount : Int = dis
    def discount(d : Int) : Unit = {
      if(d >= 0) dis = d
    }
    override def id: Int = Value.id
  }
  protected object Type{
    def apply: Type = new Type()
    def apply(d : Int) : Type = new Type(d)
  }

  val Default,New,Vip = Type
}
