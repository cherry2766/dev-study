import React from 'react';
import { Link } from 'react-router-dom';
import PropTypes from 'prop-types';
import styles from './Movie.module.css';
import { GENRE_MAP } from './Genres';

const Movie = ({ id, poster_path, title, overview, genre, year }) => {
  return (
    <div className={styles.movie}>
      <img alt={title} className={styles.movie__img} src={poster_path} />
      <div>
        <h2 className={styles.movie__title}>
          <Link to={`${process.env.PUBLIC_URL}/movie/${id}`}>{title}</Link>
        </h2>
        <h3 className={styles.movie__year}>{year}</h3>
        <p>
          {overview.length > 235 ? `${overview.slice(0, 235)}...` : overview}
        </p>
        <ul className={styles.movie__genres}>
          {genre.map((gid) => (
            <li key={gid}>{GENRE_MAP[gid] ?? gid}</li>
          ))}
        </ul>
      </div>
    </div>
  );
};

Movie.propTypes = {
  id: PropTypes.number.isRequired,
  poster_path: PropTypes.string.isRequired,
  title: PropTypes.string.isRequired,
  overview: PropTypes.string.isRequired,
  genre: PropTypes.arrayOf(PropTypes.number).isRequired,
  year: PropTypes.string.isRequired,
};

export default Movie;
