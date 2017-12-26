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
public class CreateDemoContent {

    public static void main(String[] args) throws Exception {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");

       

        // SET PALESTRANTES        
        Palestrante pa1 = new Palestrante();
        pa1.setId(1L);

        Palestrante pa2 = new Palestrante();
        pa2.setId(2L);
		
		List<Palestrante> palestrantes = new ArrayList();
		palestrantes.add(pa1);
		palestrantes.add(pa2);
		
		// SET LOCAL		
		Local l = new Local();
		l.setId(1L);
		
		// CREATE PALESTRA       
        Palestra p = new Palestra();
        p.setTitulo("java com Avéia");
        p.setLocal(l);
        p.setDuracao(100);
        p.setDataHora(df.parse("26/09/2017 19:00"));        
        p.setPalestrantes(palestrantes);

        // PERSISIT PALESTRA      
        PalestraDAO dao = new PalestraDAO();
        p = dao.salvar(p);

        System.out.println("Palestra " + p.getTitulo() + " salva com sucesso"); 
		
		

    }

}
