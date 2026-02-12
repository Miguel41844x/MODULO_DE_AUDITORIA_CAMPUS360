import "./ExportPage.css";

function ExportPage() {

  const handleExport = () => {
    alert("Archivo exportado correctamente (simulado)");
  };

  return (
    <div className="page">
      <h2>Exportar Bitácora</h2>
      <div className="export-box">
        <p>Descargar los registros en formato CSV.</p>
        <button onClick={handleExport}>Exportar</button>
      </div> 
    </div>
  );
}

export default ExportPage;
