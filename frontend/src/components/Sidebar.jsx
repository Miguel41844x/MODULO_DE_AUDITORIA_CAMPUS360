import { Link } from "react-router-dom";
import { useState } from "react";
import "./Sidebar.css";
import { FaBook, FaHistory, FaFileExport, FaChevronDown } from "react-icons/fa";
import { AiOutlineAudit } from "react-icons/ai";

function Sidebar() {
  const [open, setOpen] = useState(false);

  return (
    <div className="sidebar">
      <h3>Campus 360</h3>

      <ul>
        <li>
          <a
            className="dropdown-toggle"
            onClick={() => setOpen(!open)}
          >
            <span>
              <AiOutlineAudit />
              Auditoría
            </span>
            <FaChevronDown className={open ? "rotate" : ""} />
          </a>

          {open && (
            <ul className="submenu">
              <li>
                <Link to="/"><FaBook />Bitácora</Link>
              </li>
              <li>
                <Link to="/history"><FaHistory />Historial</Link>
              </li>
              <li>
                <Link to="/export"><FaFileExport />Exportar</Link>
              </li>
            </ul>
          )}
        </li>
      </ul>
    </div>
  );
}

export default Sidebar;