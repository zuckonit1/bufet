package com.zuckonit.bufet.stores

import javax.ws.rs.NotFoundException

import com.fasterxml.jackson.annotation.JsonProperty

/** An entity base */
trait Entity {
  /** Entity's ID */
  def id: Int
}

/** A named entity base */
trait Named extends Entity {
  /** Entity's name */
  def name: String

  /** Entity's type name (same as case class name without package) */
  @JsonProperty("type")
  def `type` = getClass.getSimpleName
}

/** A reference to named entity, helps to displays lists in UI. */
case class NamedRef(id: Int, name: String, iconId: Option[Int] = None)

/** A store interface which provides access to named entities */
trait NamedStore[T <: Named] {
  /** Lists named entities.
    *
    * @return all entities defined in store
    */
  def list: Array[T]

  /** Lists named entities.
    *
    * @return all entities with names contains search request defined in store
    */
  def find(req: String): Array[T]

  /** Loads entity by ID.
    *
    * @param id entity's ID
    * @return loaded entity
    */
  def load(id: Int): T

  /** Updates or creates (if ID is 0) entity in store.
    *
    * @param t entity to update or create
    * @return updated or created entity
    */
  def update(t: T): T

  /** Removes entity from store
    *
    * @param id entity's ID
    */
  def remove(id: Int)

  /** Creates entity's copy in store
    *
    * @param id entity's ID
    * @return entity's copy created in store
    */
  def copy(id: Int): T = {
    val entity = load(id)
    val pref = nameInd(entity.name)._1
    val ind = list.filter(_.name startsWith pref).flatMap(r => nameInd(r.name)._2)
    val name = if (ind.isEmpty) s"$pref(1)" else s"$pref(${ind.max + 1})"
    update(copy(entity, name))
  }

  /** Checks if entity exists.
    *
    * @param id entity's ID
    * @return true if entity is defined in store, false otherwse.
    */
  def exist(id: Int): Boolean = list.exists(_.id == id)

  /** Makes entity copy with new name (without persisting it).
    *
    * @param entity entity object to copy
    * @param name   new name
    * @return copied entity object
    */
  protected def copy(entity: T, name: String): T

  protected def nameInd(name: String) = "(.*)\\((\\d+)\\)".r
    .findFirstMatchIn(name).map(r => (r.group(1), Option(r.group(2)).map(_.toInt))).getOrElse(name, None)

  protected def chkName(t: T): Boolean = find(t.name).exists(r => r.name == t.name && (t.id == 0 || r.id != t.id))
}

class EntityNotFoundException extends NotFoundException("Requested object was not found.")