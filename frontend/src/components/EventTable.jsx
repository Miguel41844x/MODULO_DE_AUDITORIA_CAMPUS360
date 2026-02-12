import { Link } from "react-router-dom";

const eventosMock = [
  { id: 1, usuario: "admin", accion: "LOGIN", fecha: "2026-02-10" },
  { id: 2, usuario: "maria", accion: "APROBACION", fecha: "2026-02-09" }
];

function EventTable({ filter }) {
  const filtrados = eventosMock.filter(e =>
    e.usuario.toLowerCase().includes(filter.toLowerCase())
  );

  return (
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Usuario</th>
          <th>Acción</th>
          <th>Fecha</th>
        </tr>
      </thead>
      <tbody>
        {filtrados.map(evento => (
          <tr key={evento.id}>
            <td>
              <Link to={`/event/${evento.id}`}>{evento.id}</Link>
            </td>
            <td>{evento.usuario}</td>
            <td>{evento.accion}</td>
            <td>{evento.fecha}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default EventTable;
