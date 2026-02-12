import { useState } from "react";
import "./AuditPage.css";
import Navbar from "../components/Navbar";
import Sidebar from "../components/Sidebar";
import Filters from "../components/Filters";
import EventTable from "../components/EventTable";
import "../App.css";

function AuditPage() {
  const [filter, setFilter] = useState("");

  return (
    <>
      <Navbar />
      <div className="layout">
        <Sidebar />
        <div className="content">
          <h2>Bitácora de eventos</h2>
          <Filters setFilter={setFilter} />
          <EventTable filter={filter} />
        </div>
      </div>
    </>
  );
}

export default AuditPage;
