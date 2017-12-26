package eventum.test;

import eventum.dao.LocalDAO;
import eventum.dao.PalestraDAO;
import eventum.dao.PalestranteDAO;
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
public class CreateDemoContent {

    public static void main(String[] args) throws Exception {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        // CREATE LOCAL
        Local l1 = new Local();
        l1.getId();
        
        l1.setPredio("Lambda");
        l1.setSala("L115");
        l1.setCapacidade(80);

        Local l2 = new Local();
        l2.getId();
        l2.setPredio("Gama");
        l2.setSala("G155");
        l2.setCapacidade(75);

        Local l3 = new Local();
        l3.getId();
        l3.setPredio("Omega");
        l3.setSala("O190");
        l3.setCapacidade(75);
        
        LocalDAO localdao = new LocalDAO();
        localdao.salvar(l1);
        localdao.salvar(l2);
        localdao.salvar(l3);
        
        // CREATE PALESTRANTES
        List<Palestrante> palestrantes = new ArrayList<>();

        Palestrante pa1 = new Palestrante();
        pa1.setNome("Rafael Sakurai");
        pa1.setMiniBio("Professor de desenvolvimento de software");

        Palestrante pa2 = new Palestrante();
        pa2.setNome("Lucas Venezian");
        pa2.setMiniBio("Professor de Banco de Dados");

        Palestrante pa3 = new Palestrante();
        pa3.setNome("James Goslin");
        pa3.setMiniBio("Criador do Java e fundador da Sun");
        
        PalestranteDAO padao = new PalestranteDAO();        
        padao.salvar(pa1);
        padao.salvar(pa2);
        padao.salvar(pa3);
        
        // CREATE PALESTRAS        
        Palestra p1 = new Palestra();
        p1.setTitulo("Relacionamento @OneToMay e @ManyToOne com JPA");
        p1.setLocal(l1);
        p1.setDuracao(90);
        p1.setDataHora(df.parse("26/09/2014 20:00"));
        palestrantes.add(pa1);
        p1.setPalestrantes(palestrantes);
        
        Palestra p2 = new Palestra();
        p2.setTitulo("Redes neurais artificiais e tratamento em R");
        p2.setLocal(l2);
        p2.setDuracao(120);
        p2.setDataHora(df.parse("27/09/2014 19:00"));
        palestrantes.add(pa2);
        p2.setPalestrantes(palestrantes);

        Palestra p3 = new Palestra();
        p3.setTitulo("Java e Kotlin: integraçao total e curva de aprendizado");
        p3.setLocal(l3);
        p2.setDuracao(60);
        p3.setDataHora(df.parse("28/09/2014 19:00"));
        palestrantes.add(pa3);
        p3.setPalestrantes(palestrantes);

        // PERSISITIR        
        PalestraDAO dao = new PalestraDAO();
        dao.salvar(p1);
        dao.salvar(p2);
        dao.salvar(p3);

        System.out.println("Palestra " + p1.getTitulo() + " salva com sucesso");
        System.out.println("Palestra " + p2.getTitulo() + " salva com sucesso");
        System.out.println("Palestra " + p3.getTitulo() + " salva com sucesso");

    }

}
