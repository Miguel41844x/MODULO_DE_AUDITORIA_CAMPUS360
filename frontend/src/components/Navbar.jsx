import { Link } from "react-router-dom";
import "./Navbar.css";

function Navbar() {
  return (
    <nav className="navbar">
      <h2>Campus360 - Auditoría</h2>
      <div className="nav-links">
        <Link to="/">Bitácora</Link>
        <Link to="/history">Historial</Link>
        <Link to="/export">Exportar</Link>
      </div>
    </nav>
  );
}

export default Navbar;
