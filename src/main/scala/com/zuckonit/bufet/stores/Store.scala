package com.zuckonit.bufet.stores

import com.zuckonit.bufet.models.Entity

trait Store {
  def getAll()
  def getById()
  def deleteById()
  def addToStore(entity : Entity)
}
