package com.zuckonit.bufet.stores

trait StoreFactory {
  def login(login: String, password: String): Store
}

trait Store {

  var user: User

  def users: UsersStore
  def clients: ClientsStore
  def employees: EmployeesStore
  def bufets: BufetsStore
  def dishes: DishesStore
  def descs: DescsStore
  def orders: OrdersStore
  def phrases: PhrasesStore
  def products: ProductsStore

}