package eventum.test;

import exemplo.jpa.dao.PalestraDAO;
import exemplo.jpa.modelo.Local;
import exemplo.jpa.modelo.Palestra;
import exemplo.jpa.modelo.Palestrante;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nimb
 */
public class TesteEvento {

    public static void main(String[] args) throws Exception {
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Local l1 = new Local();
        l1.setPredio("Lambda");
        l1.setSala("L115");
        l1.setCapacidade(80);
        
        Palestra p = new Palestra();
        p.setTitulo("Relacionamento com JPA");
        p.setLocal(l1);
        p.setDataHora(df.parse("26/09/2014 19:00"));
        
        
        Palestrante pa = new Palestrante();
        pa.setNome("Rafael Sakurai");
        pa.setMiniBio("Professor de desenvolvimento de software");
        
        List<Palestrante> palestrantes = new ArrayList();
        palestrantes.add(pa);
        
        p.setPalestrantes(palestrantes);
        pa.setPalestra(p);
        
        
        PalestraDAO dao = new PalestraDAO();
        p = dao.salvar(p);
        
        System.out.println("Palestra " + p.getTitulo() + " salva com sucesso");
        
        

//        Local l2 = new Local();
//        l2.setPredio("Gama");
//        l2.setSala("G155");
//        l2.setCapacidade(75);
//
//        Local l3 = new Local();
//        l3.setPredio("Omega");
//        l3.setSala("O190");
//        l3.setCapacidade(75);
//
//        LocalDAO dao = new LocalDAO();
//        l1 = dao.salvar(l1);
//        l2 = dao.salvar(l2);
//        l3 = dao.salvar(l3);
//
//        System.out.println("Local salvo " + l1.getIdlocal() + " " + l1.getPredio() + " " + l1.getSala() + " " + l1.getCapacidade());
//        System.out.println("Local salvo " + l2.getIdlocal() + " " + l2.getPredio() + " " + l2.getSala() + " " + l2.getCapacidade());
//        System.out.println("Local salvo " + l3.getIdlocal() + " " + l3.getPredio() + " " + l3.getSala() + " " + l3.getCapacidade());
//        
        
        
    }

}
