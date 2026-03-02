import { useEffect, useState } from "react";

function EventTable({ filters }) {

  const [eventos, setEventos] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/auditoria")
      .then(res => res.json())
      .then(data => setEventos(data))
      .catch(err => console.error(err));
  }, []);

  const filtrados = eventos.filter(e => {

    const filtroUsuario =
      !filters.usuario ||
      e.usuario?.nombre
        ?.toLowerCase()
        .includes(filters.usuario.toLowerCase());

    const filtroFecha =
      !filters.fecha ||
      e.fecha?.startsWith(filters.fecha);

    return filtroUsuario && filtroFecha;
  });

  return (
    <div className="card">
      <table className="event-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Entidad</th>
            <th>Acción</th>
            <th>Usuario</th>
            <th>Fecha</th>
            <th>Descripción</th>
          </tr>
        </thead>
        <tbody>
          {filtrados.map(evento => (
            <tr key={evento.idEvento}>
              <td>{evento.idEvento}</td>
              <td>{evento.entidad?.tipoEntidad}</td>
              <td>{evento.accion}</td>
              <td>{evento.usuario?.nombre}</td>
              <td>{new Date(evento.fecha).toLocaleString()}</td>
              <td>{evento.descripcion}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default EventTable;