/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Topics;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lenovo
 */
@Local
public interface TopicsFacadeLocal {

    void create(Topics topics);

    void edit(Topics topics);

    void remove(Topics topics);

    Topics find(Object id);

    List<Topics> findAll();

    List<Topics> findRange(int[] range);

    int count();
    
}
