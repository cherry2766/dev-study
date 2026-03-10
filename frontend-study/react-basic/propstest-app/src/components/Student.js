import React from 'react';

const Student = ({ student }) => {
  return (
    <div>
      <h2>name : {student.name}</h2>
      <h2>age : {student.age}</h2>
      <h2>year : {student.year}</h2>
      <h2>address : {student.address}</h2>
    </div>
  );
};

export default Student;
