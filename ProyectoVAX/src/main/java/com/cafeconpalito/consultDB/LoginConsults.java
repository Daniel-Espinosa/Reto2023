/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.consultDB;

import com.cafeconpalito.entities.Usuario;
import com.cafeconpalito.staticElements.ConectionBBDD;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Query;

/**
 *
 * @author Ramiro
 */
public class LoginConsults {
    
    
    public static boolean userExists(String email){
        Query q = ConectionBBDD.getEm().createNamedQuery("Usuario.findByEmail");
        q.setParameter("email", email);
        ArrayList<Usuario> l = (ArrayList<Usuario>) q.getResultList();
        
        if (!l.isEmpty()) {
            return true;
        }
        return false;
    }
    
    
    public static boolean passwordCorrect(String email,String pass){
        Query q = ConectionBBDD.getEm().createNamedQuery("Usuario.userAndPwdCorrect");
        q.setParameter("email", email);
        q.setParameter("pwd", pass);
        ArrayList<Usuario> l = (ArrayList<Usuario>) q.getResultList();
        
        if (!l.isEmpty()) {
            return true;
        }
        return false;
    }
    
    public static void loadUserData(String email){
        
        Query q = ConectionBBDD.getEm().createNamedQuery("Usuario.findByEmail");
        q.setParameter("email", email);
        ArrayList<Usuario> l = (ArrayList<Usuario>) q.getResultList();
        
    }
    
    
}