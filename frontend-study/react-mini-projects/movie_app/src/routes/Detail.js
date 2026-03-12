import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';

const Detail = () => {
  const { id } = useParams();
  const [loading, setLoading] = useState(true);
  const [movie, setMovie] = useState({});
  const getMovie = async () => {
    const json = await (
      await fetch(`https://nomad-movies.nomadcoders.workers.dev/movies/${id}`)
    ).json();
    setMovie(json);
    setLoading(false);
    console.log(json);
  };
  useEffect(() => {
    getMovie();
  }, []);
  useEffect(() => {
    window.scrollTo(0, 0);
  }, []);
  return (
    <div>
      <h1 style={{ margin: '10px' }}>Detail</h1>
      {loading ? (
        <h1 style={{ margin: '10px' }}>loading...</h1>
      ) : (
        <div style={{ margin: '10px' }}>
          <img
            style={{ width: '550px', height: '300px' }}
            src={movie.backdrop_path}
          />
          <h2>Title : {movie.title}</h2>
          <p>Tagline : {movie.tagline}</p>
          <p>release_date : {movie.release_date}</p>
          <p>runtime : {movie.runtime}</p>
        </div>
      )}
    </div>
  );
};

export default Detail;
