import "./HistoryPage.css";


function HistoryPage() {
  return (
    <div className="page">
      <h2>Historial de Cambios</h2>
      <p>Aquí se muestran los cambios realizados en entidades del sistema.</p>

      <table>
        <thead>
          <tr>
            <th>Entidad</th>
            <th>Campo</th>
            <th>Valor Anterior</th>
            <th>Valor Nuevo</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Solicitud #12</td>
            <td>Estado</td>
            <td>Pendiente</td>
            <td>Aprobado</td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}

export default HistoryPage;
