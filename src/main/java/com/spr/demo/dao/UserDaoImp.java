package com.spr.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import com.spr.demo.models.User;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import org.springframework.stereotype.Repository;

/*
En esta clase se implementan los metodos de la interfaz de la clase abstracta
como estamos aplicando el patrón de diseño REST se debe usar OverRide y sobreescribir
al método de la interfaz userDAO
*/
@Repository // Referencia al repositorio de la base de datos
@Transactional // le da la funcionalidad a la clase para hacer consultas SQL
public class UserDaoImp implements UserDao{
  @PersistenceContext // Referencia a la base de datos
  EntityManager entityManager; // conexion con la base de datos

  @Override
  public List<User> get_users() {
    String query = "FROM User"; // se coloca el nombre del modelo User
    return entityManager.createQuery(query,User.class).getResultList(); // se crea la consulta y se obtiene el resultado
  }
  @Override  
  public User get_user(int id){
    return entityManager.find(User.class,id); // obtiene el usuario con el id especificado
  }
  @Override
  public String create_user(User user) {
    Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i); // se crea el objeto Argon2
    user.setPassword(argon2.hash(2, 1024, 1, user.getPassword())); // se encripta la contraseña, n° e  iteracionens para encriptar la contraseña, tamaño de la contraseña
    entityManager.merge(user); // se crea el usuario en la base de datos
    return "Usuario creado"; // se retorna un mensaje de exito
  }
  @Override
  public User edit_user(int id) {
    // TODO Auto-generated method stub
    return null;
  }  
  @Override  
  public String delete_user(int id){
    User user = get_user(id); // obtiene el usuario con el id especificado
    if(user == null){ // si el usuario no existe
      return "El usuario no existe"; // se retorna el mensaje de error
    }
    entityManager.remove(user);
    return "El usuario ha sido eliminado"; // se retorna el mensaje de exito
  }
  @Override
  public boolean verify_credentials(User user) {
    String query = "FROM User WHERE user_name = :user_name"; // anti inyeccion sql
    List <User> some_user =  entityManager.createQuery(query,User.class).setParameter("user_name",user.getUser_name()).getResultList(); // se crea la consulta y se obtiene el resultado
    if(some_user.isEmpty()){
      return false;
    }
    String hashed_password = some_user.get(0).getPassword(); // se obtiene la contraseña encriptada del usuario
    Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i); // se crea el objeto Argon2
    return argon2.verify(hashed_password, user.getPassword()); // se verifica la contraseña encriptada con la contraseña ingresada por el usuario
  }
}
