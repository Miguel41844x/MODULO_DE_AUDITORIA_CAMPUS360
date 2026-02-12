import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Dashboard from "./pages/Dashboard";
import HistoryPage from "./pages/HistoryPage";
import EventDetail from "./pages/EventDetail";
import ExportPage from "./pages/ExportPage";
import "./App.css";
function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Dashboard />} />
        <Route path="/history" element={<HistoryPage />} />
        <Route path="/event/:id" element={<EventDetail />} />
        <Route path="/export" element={<ExportPage />} />
      </Routes>
    </Router>
  );
}

export default App;
