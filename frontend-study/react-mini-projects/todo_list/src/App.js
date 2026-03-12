import { useState } from 'react';

function App() {
  const [text, setText] = useState('');
  const [list, setList] = useState([]);

  const onChange = (e) => setText(e.target.value);

  const onSubmit = (e) => {
    e.preventDefault();
    if (text === '') return;
    setList((prev) => [text, ...prev]);
    setText('');
  };

  const onDelete = (index) => {
    setList((prev) => prev.filter((_, i) => i !== index));
  };

  return (
    <div>
      <div>
        <h1>To-Do List</h1>

        <form onSubmit={onSubmit}>
          <input
            value={text}
            onChange={onChange}
            type="text"
            placeholder="Please Enter a New task"
          />
          <button type="submit">ADD</button>
        </form>

        <ul>
          {list.map((item, index) => (
            <li key={item + index}>
              <input type="checkbox" />
              <span>{item}</span>
              <button onClick={() => onDelete(index)}>Delete</button>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default App;
