import { useParams } from "react-router-dom";
import "./EventDetail.css";

function EventDetail() {
  const { id } = useParams();

  return (
    <div className="page">
      <h2>Detalle del Evento #{id}</h2>
      <p><strong>Usuario:</strong> admin</p>
      <p><strong>Acción:</strong> APROBACIÓN</p>
      <p><strong>Fecha:</strong> 2026-02-10</p>
      <p><strong>IP:</strong> 192.168.1.10</p>
    </div>
  );
}

export default EventDetail;
