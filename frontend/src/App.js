import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import MetricChooserPage from './pages/MetricChooserPage';
import WorkspacePage from "./pages/WorkspacePage";
import 'bootstrap/dist/css/bootstrap.min.css';


function App() {
  return (
      <Router>
          <Routes>
              <Route path="/" element={<WorkspacePage />} />
              <Route path="/create" element={<MetricChooserPage />} />
          </Routes>
      </Router>

  );
}

export default App;
