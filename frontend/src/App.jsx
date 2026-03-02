import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Sidebar from "./components/Sidebar";
import Dashboard from "./pages/Dashboard";
import HistoryPage from "./pages/HistoryPage";
import EventDetail from "./pages/EventDetail";
import ExportPage from "./pages/ExportPage";
import "./App.css";

function App() {
  return (
    <Router>
      <div className="layout">
        <Sidebar />
        <div className="content">
          <Routes>
            <Route path="/" element={<Dashboard />} />
            <Route path="/history" element={<HistoryPage />} />
            <Route path="/event/:id" element={<EventDetail />} />
            <Route path="/export" element={<ExportPage />} />
          </Routes>
        </div>
      </div>
    </Router>
  );
}

export default App;
