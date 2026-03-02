  import "./ExportPage.css";

  function ExportPage() {

    const handleExport = async () => {
      try {
        const response = await fetch(
          "http://localhost:8080/api/auditoria/exportar"
        );

        if (!response.ok) {
          throw new Error("Error al exportar");
        }

        const blob = await response.blob();
        const url = window.URL.createObjectURL(blob);

        const a = document.createElement("a");
        a.href = url;
        a.download = "bitacora.xlsx";
        document.body.appendChild(a);
        a.click();
        a.remove();

      } catch (error) {
        console.error(error);
        alert("Error al exportar archivo");
      }
    };

    return (
      <div className="page">
        <h2>Exportar Bitácora</h2>
        <div className="export-box">
          <p>Descargar los registros en formato Excel.</p>
          <button onClick={handleExport}>Exportar</button>
        </div>
      </div>
    );
  }

  export default ExportPage;