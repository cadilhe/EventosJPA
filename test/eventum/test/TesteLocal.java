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
public class TesteLocal {

    public static void main(String[] args) throws Exception {

        Local l = new Local();
        l.setPredio("Sigma");
        l.setSala("S111");
        l.setCapacidade(55);
////        
        LocalDAO dao = new LocalDAO();////        
        l = dao.salvar(l);
////        
//        
        Local l2 = dao.consultarPorId(l.getId());

        System.out.println("Consultado o local " + l.getId() + " com capacidade de " + l.getCapacidade());

        l2.setCapacidade(120);

        System.out.println("Atualizando capacidade");

        dao.salvar(l2);

        System.out.println("Consultado o local " + l.getId() + " com capacidade de " + l.getCapacidade());

        System.out.println("Removendo...");

        dao.remover(l.getId());

    }

}
