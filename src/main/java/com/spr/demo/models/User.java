package com.spr.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users") // hace referencia a la tabla users de la base de datos
public class User {
  @Id
  @Getter @Setter @Column(name = "id") // hace referencia a la columna id de la tabla users de la base de datos
  private int id;
  @Getter @Setter @Column(name = "name") // hace referencia a la columna name de la tabla users de la base de datos
  private String name;
  @Getter @Setter @Column(name = "last_name") // hace referencia a la columna last_name de la tabla users de la base de datos
  private String email;
  @Getter @Setter @Column(name = "password") // hace referencia a la columna password de la tabla users de la base de datos
  private String password;
  @Getter @Setter @Column(name = "phone") // hace referencia a la columna role de la tabla users de la base de datos
  private String phone;
  @Getter @Setter @Column(name = "role_id") // hace referencia a la columna role de la tabla users de la base de datos
  private int roleID;
}
