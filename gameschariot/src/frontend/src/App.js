import './App.css';
import GamesChariot from './Controllers/GamesChariotController';
import GamesApi from './Controllers/GamesChariotApiController';
import {Route, Routes} from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <header className="App-header">
      </header>
      <main>
              <Routes>
                  <Route path='/' element={<GamesChariot/>}>
                  </Route>
                  <Route path='/api' element={<GamesApi/>}>
                  </Route>
              </Routes>
      </main>
    </div>
  );
}

export default App;
