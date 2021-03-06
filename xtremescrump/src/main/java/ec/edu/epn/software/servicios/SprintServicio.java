package ec.edu.epn.software.servicios;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.Query;
import ec.edu.epn.software.entidades.Proyecto;
import ec.edu.epn.software.entidades.Sprint;
import static ec.edu.epn.software.servicios.objectify.OfyService.ofy;
import java.util.List;

public class SprintServicio extends ServicioBase<Sprint> {

    public SprintServicio() {
        super(Sprint.class, SprintServicio.class);
    }

    public List<Sprint> buscarPorProyecto(Long idProyecto) {
        System.out.println("Buscando Proyectos con Id = " + idProyecto);
        Key<Proyecto> proyectoKey = Key.create(Proyecto.class, idProyecto);
        Query<Sprint> query = ofy().load().type(Sprint.class);
        List<Sprint> list = query.filter("proyecto", proyectoKey).list();
        return list;
    }

}
