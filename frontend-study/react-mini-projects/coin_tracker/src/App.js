import { useEffect, useState } from 'react';

function App() {
  const [loading, setLoading] = useState(true);
  const [coins, setCoins] = useState([]);
  const [value, setValue] = useState('');
  const [selectedId, setSelectedId] = useState(''); // 선택한 코인 아이디

  useEffect(() => {
    fetch('https://api.coinpaprika.com/v1/tickers')
      .then((Response) => Response.json())
      .then((json) => {
        setCoins(json);
        setLoading(false);
      });
  }, []);

  const selectedCoin = coins.find((coin) => coin.id === selectedId);
  const price = selectedCoin?.quotes?.USD?.price;
  const dollars = Number(value);
  const canBuy = price && dollars > 0 ? dollars / price : 0;

  return (
    <div>
      <h1>The Coins! {loading ? '' : `(${coins.length})`}</h1>

      {loading ? (
        <strong>Loading...</strong>
      ) : (
        <select
          value={selectedId}
          onChange={(e) => setSelectedId(e.target.value)}
        >
          <option value="">-- 코인을 선택하세요 --</option>

          {coins.map((coin) => (
            <option key={coin.id} value={coin.id}>
              {coin.name}({coin.symbol}): ${coin.quotes.USD.price} USD
            </option>
          ))}
        </select>
      )}

      <input
        onChange={(e) => setValue(e.target.value)}
        value={value}
        type="number"
        placeholder="Enter the amount of money you have:"
      />
      <br />

      {selectedCoin && dollars > 0 && typeof price === 'number' ? (
        <p>
          ${dollars}로 <b>{selectedCoin.name}</b>를 <b>{canBuy.toFixed(8)}</b>개
          살 수 있어요.
        </p>
      ) : (
        <p>코인을 선택하고 달러 금액을 입력하세요.</p>
      )}
    </div>
  );
}

export default App;
