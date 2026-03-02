import { useState } from "react";
import EventTable from "../components/EventTable";
import Filters from "../components/Filters";
import "./Dashboard.css";

function Dashboard() {

  const [filters, setFilters] = useState({
    usuario: "",
    fecha: ""
  });

  return (
    <div className="page">
      <h2>Bitácora de eventos</h2>

      <Filters setFilters={setFilters} />

      <EventTable filters={filters} />
    </div>
  );
}

export default Dashboard;