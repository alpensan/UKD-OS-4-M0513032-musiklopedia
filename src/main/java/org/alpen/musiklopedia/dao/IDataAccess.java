/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alpen.musiklopedia.dao;

import java.io.Serializable;
import java.util.List;
import static javafx.scene.input.KeyCode.T;


public interface IDataAccess<T> extends Serializable {
    
   public void insert(T obj);
   public void update(T obj);
   public void delete(T obj);
   public List<T> getAll();
   public T getById(int id);
   public T getById(String id);
   public List<T> getByProperty(String name, Object value);
   public List<T> search(String name, Object value); 
}
