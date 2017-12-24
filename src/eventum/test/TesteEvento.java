package eventum.test;

import eventum.dao.PalestraDAO;
import eventum.model.Local;
import eventum.model.Palestra;
import eventum.model.Palestrante;
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
        l1.setId(1);
//        l1.setPredio("Lambda");
//        l1.setSala("L115");
//        l1.setCapacidade(80);
        
        Palestra p1 = new Palestra();
        p1.setTitulo("Relacionamento @OneToMay e @ManyToOne com JPA");
        p1.setLocal(l1);
        p1.setDataHora(df.parse("27/09/2014 20:00"));
        
        
        Palestrante pa = new Palestrante();
        pa.setNome("Rafael Sakurai");
        pa.setMiniBio("Professor de desenvolvimento de software");
        
        List<Palestrante> palestrantes = new ArrayList();
        palestrantes.add(pa);
        
        p1.setPalestrantes(palestrantes);
        pa.setPalestra(p1);
        
        
        PalestraDAO dao = new PalestraDAO();
        p1 = dao.salvar(p1);
        
        System.out.println("Palestra " + p1.getTitulo() + " salva com sucesso");
        
        

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
