import "./Filters.css";

function Filters({ setFilter }) {
  return (
    <div className="filters">
      <input
        type="text"
        placeholder="Filtrar por usuario..."
        onChange={(e) => setFilter(e.target.value)}
      />

      <input type="date" />
      <button>Buscar</button>
    </div>
  );
}

export default Filters;
