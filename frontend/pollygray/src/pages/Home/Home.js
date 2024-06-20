import React from "react";

const Home = () => {
  return (
    <div>
      <h1>Polly Gray Gallery</h1>
      <ul>
        <li>
          <a href="/login">Login</a>
        </li>
        <li>
          <a href="/signup">Register</a>
        </li>
      </ul>

      <br />
      <h2>Session Storage (Debug)</h2>
      <pre>
        {"Logged user: " + sessionStorage.user}
        {"\nLogged token: " + sessionStorage.token}
      </pre>
    </div>
  );
};

export default Home;
