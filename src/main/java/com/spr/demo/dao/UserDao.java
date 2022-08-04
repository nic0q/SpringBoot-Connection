// Un DAO es un objeto que se encarga de realizar las operaciones de persistencia de datos.
// con la base de datos

package com.spr.demo.dao;
import com.spr.demo.models.User;
import java.util.List;
// Una interfaz es una clase abstracta que contiene metodos abstractos, es decir, que no contiene cuerpo de codigo.
// solo contiene los encabezados de tales funciones | metodos que deben ser creados en el clase que los implementa
// en este caso sera al clase UserDaoImp

public interface UserDao {
  List<User> getUsers();
}
