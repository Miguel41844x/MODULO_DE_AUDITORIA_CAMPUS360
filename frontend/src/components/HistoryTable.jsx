import { useEffect, useState } from "react";

function HistoryTable() {

  const [eventos, setEventos] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/auditoria/historial/1")
      .then(res => res.json())
      .then(data => setEventos(data))
      .catch(err => console.error(err));
  }, []);

  return (
    <div className="card">
      <table className="history-table">
        <thead>
          <tr>
            <th>Entidad</th>
            <th>Campo</th>
            <th>Valor Anterior</th>
            <th>Valor Nuevo</th>
            <th>Fecha</th>
          </tr>
        </thead>
        <tbody>
          {eventos.map(evento =>
            evento.cambios?.map(cambio => (
              <tr key={cambio.idCambio}>
                <td>{evento.entidad?.tipoEntidad}</td>
                <td>{cambio.campo}</td>
                <td>{cambio.valorAntiguo}</td>
                <td>{cambio.valorNuevo}</td>
                <td>{evento.fecha}</td>
              </tr>
            ))
          )}
        </tbody>
      </table>
    </div>
  );
}

export default HistoryTable;