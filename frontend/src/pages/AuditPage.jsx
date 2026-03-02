import { useEffect, useState } from "react";
import "./AuditPage.css";
import Navbar from "../components/Navbar";
import Sidebar from "../components/Sidebar";
import Filters from "../components/Filters";
import EventTable from "../components/EventTable";
import "../App.css";

function AuditPage() {
  
  useEffect(() => {
    fetch("http://localhost:8080/api/auditoria")
      .then(response => response.json())
      .then(data => {
        setEventos(data);
      })
      .catch(error => console.error("Error:", error));
  }, []);
  
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
