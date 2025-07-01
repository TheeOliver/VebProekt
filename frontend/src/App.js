import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import MetricChooserPage from './pages/MetricChooserPage';
import WorkspacePage from "./pages/WorkspacePage";
import 'bootstrap/dist/css/bootstrap.min.css';


function App() {
  return (
      <body className={"p-6"}>
      <WorkspacePage/>
      </body>

  );
}

export default App;
