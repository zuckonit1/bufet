package com.zuckonit.bufet.servers

import com.zuckonit.bufet.db.Tables
import com.zuckonit.bufet.stores.{Language, LanguageStore}
import com.zuckonit.bufet.db.tables.records._
import com.zuckonit.bufet.utils.DB

import scala.collection.JavaConversions._

object LanguageServer extends LanguageStore with DB{

  implicit def languageRecord2Language(languageRecord: LanguageRecord): Language = {
    Language(
      languageRecord.getId,
      languageRecord.getShortName,
      languageRecord.getFullName,
      languageRecord.getEnabled,
      languageRecord.getMajor
    )
  }

  implicit def language2LanguageRecord(language : Language) : LanguageRecord = {
    new LanguageRecord(language.id,language.shortName,language.fullName,language.enabled,language.major)
  }

  override def list: Array[Language] = context.selectFrom(Tables.LANGUAGE).fetchArray().map(l=> l:Language)

  override def find(req: String): Array[Language] = list.filter(l => l.fullName.equals(req) || l.shortName.equals(req))

  override def load(id: Int): Language = list.find(l => l.id == id) match {
    case Some(language) => language
    case _ => throw new NullPointerException
  }

  override def update(t: Language): Language = ???

  override def remove(id: Int): Unit = ???

  override protected def copy(entity: Language, name: String): Language = ???
}
