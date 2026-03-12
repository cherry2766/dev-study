import { useEffect, useState } from 'react';
import Movie from '../components/Movie';
import styles from "./Home.module.css";

const Home = () => {
  const [loading, setLoading] = useState(true);
  const [movies, setMovies] = useState([]);
  const getMovies = async () => {
    const response = await fetch(
      'https://nomad-movies.nomadcoders.workers.dev/movies',
    );
    const json = await response.json();
    // const json = await (await fetch(
    //   'https://nomad-movies.nomadcoders.workers.dev/movies')).json();
    setMovies(json);
    setLoading(false);
  };
  useEffect(() => {
    getMovies();
  }, []);

  console.log(movies);

  return (
    <div className={styles.container}>
      {loading ? (
        <div className={styles.loader}>
          <h1>Loading...</h1>
        </div>
      ) : (
        <div className={styles.movies}>
          {movies.map((movie) => (
            <Movie
              id={movie.id}
              key={movie.id}
              year={movie.release_date}
              poster_path={movie.poster_path}
              title={movie.title}
              overview={movie.overview}
              genre={movie.genre_ids}
            />
          ))}
        </div>
      )}
    </div>
  );
};

export default Home;
