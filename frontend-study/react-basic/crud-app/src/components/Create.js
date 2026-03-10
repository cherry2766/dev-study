import React from 'react';

const Create = (props) => {
  return (
    <div>
      <article>
        <hr/>
        <h2>CREATE</h2>
        <form onSubmit={
          event => {
            event.preventDefault();
            const title = event.target.title.value;
            const body = event.target.body.value;
            props.onCreate(title,body);
          }
        }> {/* submit 이벤트는 발생 주체 : form */}
          <p><input type="text" name="title" placeholder='title'/></p>
          <p><textarea name='body' placeholder='body'/></p>
          <p><input type="submit" value='create'/></p>
        </form>
      </article>
    </div>
  );
};

export default Create;