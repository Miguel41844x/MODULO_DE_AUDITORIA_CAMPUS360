import { useState } from "react";
import "./Filters.css";

function Filters({ setFilters }) {

  const [usuario, setUsuario] = useState("");
  const [fecha, setFecha] = useState("");

  const aplicarFiltros = () => {
    setFilters({
      usuario,
      fecha
    });
  };

  return (
    <div className="filters">

      <input
        type="text"
        placeholder="Filtrar por usuario..."
        value={usuario}
        onChange={(e) => setUsuario(e.target.value)}
      />

      <input
        type="date"
        value={fecha}
        onChange={(e) => setFecha(e.target.value)}
      />

      <button onClick={aplicarFiltros}>
        Buscar
      </button>

    </div>
  );
}

export default Filters;