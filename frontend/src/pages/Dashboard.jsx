import { useState } from "react";
import EventTable from "../components/EventTable";
import Filters from "../components/Filters";
import "./Dashboard.css";

function Dashboard() {
  const [filter, setFilter] = useState("");

  return (
    <div className="page">
      <h2>Bitácora de eventos</h2>
      <Filters setFilter={setFilter} />
      <EventTable filter={filter} />
    </div>
  );
}

export default Dashboard;
