import { BrowserRouter, Switch, Route } from 'react-router-dom';
import Coins from './Coins';
import Coin from './Coin';

interface RouterProps {
  toggleTheme: () => void;
  isDark: boolean;
}

const Router = ({ toggleTheme, isDark }: RouterProps) => {
  return (
    <BrowserRouter>
      <Switch>
        <Route path="/:coinId">
          <Coin />
        </Route>
        <Route path="/">
          <Coins toggleTheme={toggleTheme} isDark={isDark}/>
        </Route>
      </Switch>
    </BrowserRouter>
  );
};

export default Router;
