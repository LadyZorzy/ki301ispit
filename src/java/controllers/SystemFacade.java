/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.System;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lenovo
 */
@Stateless
public class SystemFacade extends AbstractFacade<System> {

    @PersistenceContext(unitName = "KI301ispitPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SystemFacade() {
        super(System.class);
    }
    
}
