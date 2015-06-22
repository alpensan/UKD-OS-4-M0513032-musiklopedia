/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alpen.musiklopedia.dao;

import java.util.List;
import org.alpen.musiklopedia.entity.Album;
import org.alpen.musiklopedia.util.HibernateUtil;
import org.alpen.musiklopedia.dao.EntityBase;
import org.alpen.musiklopedia.dao.IDataAccess;
import org.hibernate.Query;

public class AlbumDAO extends EntityBase implements IDataAccess<Album> {
    public AlbumDAO(){        
    }   

    @Override
    public void insert(Album obj) {
        connect();
        session.save(obj);
        session.flush();
        disconect();
    }

    @Override
    public void update(Album obj) {
        connect();
        session.update(obj);
        session.flush();
        disconect();
    }

    @Override
    public void delete(Album obj) {
        connect();
        session.delete(obj);
        session.flush();
        disconect();
    }

    @Override
    public List getAll() {
        connect();
        List<Album> produkList = session.createQuery("from Album").list();
        disconect();
        return produkList;
    }

    @Override
    public Album getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Album getById(String id) {
        connect();
        List<Album> produkList = getByProperty("id", id);
        disconect();
        if(produkList != null && produkList.size()>0){
        return produkList.get(0);
        }
        return null;
    }

    @Override
    public List<Album> getByProperty(String name, Object value) {
        connect();
        Query query = session.createQuery("from Album where " + name + " =:value");
        query.setParameter("value", value);
        List<Album> produkList = query.list();
        disconect();
        return produkList;
 }

    @Override
    public List<Album> search(String name, Object value) {
        connect();
        Query query = session.createSQLQuery("select * from Album where " + name+ " like '%" + value + "%'");
        List<Album> produkList = query.list();
        disconect();
        return produkList;
    }

    
    
}
