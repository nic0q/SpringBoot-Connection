package com.spr.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import com.spr.demo.models.User;
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
  public List<User> getUsers() {
    String query = "FROM User"; // se coloca el nombre del modelo User
    return entityManager.createQuery(query,User.class).getResultList(); // se crea la consulta y se obtiene el resultado
  }

  
}
