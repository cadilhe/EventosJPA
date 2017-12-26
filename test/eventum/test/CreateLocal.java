/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventum.test;
import eventum.dao.LocalDAO;
import eventum.model.Local;

/**
 *
 * @author sigaln
 */
public class CreateLocal {
    
    public static void main(String[] args) {        
        
        Local l2 = new Local();
        l2.setPredio("Gama");
        l2.setSala("G155");
        l2.setCapacidade(75);

        Local l3 = new Local();
        l3.setPredio("Omega");
        l3.setSala("O190");
        l3.setCapacidade(75);

        LocalDAO dao = new LocalDAO();
        
        dao.persist(l2);
        dao.persist(l3);

       
        System.out.println("Local salvo " + l2.getId() + " " + l2.getPredio() + " " + l2.getSala() + " " + l2.getCapacidade());
        System.out.println("Local salvo " + l3.getId() + " " + l3.getPredio() + " " + l3.getSala() + " " + l3.getCapacidade());
        
    }
    
}
