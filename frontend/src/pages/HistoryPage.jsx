import "./HistoryPage.css";
import HistoryTable from "../components/HistoryTable";

function HistoryPage() {
  return (
    <div className="page">
      <h2>Historial de Cambios</h2>
      <p>Aquí se muestran los cambios realizados en entidades del sistema.</p>
      <HistoryTable />
    </div>
  );
}

export default HistoryPage;