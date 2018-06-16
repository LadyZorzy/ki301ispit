/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.System;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lenovo
 */
@Local
public interface SystemFacadeLocal {

    void create(System system);

    void edit(System system);

    void remove(System system);

    System find(Object id);

    List<System> findAll();

    List<System> findRange(int[] range);

    int count();
    
}
