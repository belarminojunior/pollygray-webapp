import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import authService from "../../services/authService";

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();

    try {
      const response = authService.login();
      localStorage.setItem("token", response.data.token);
      navigate("/home");
    } catch (error) {
      alert(error);
      alert("Invalid Credentials");
    }
  };

  return (
    <div className="min-h-screen flex flex-col items-center justify-center bg-gray-100">
      <div className="bg-white p-10 rounded-lg shadow-lg w-96">
        <h2 className="text-2xl font-bold mb-5 text-center">Login</h2>
        <h3 className="text-lg font-semibold mb-5 text-center">Login Here</h3>
        <form action="" onSubmit={handleLogin} className="space-y-4">
          <div>
            <label className="block mb-1 font-semibold" htmlFor="email">
              Email:
            </label>
            <input
              className="w-full px-4 py-2 border rounded-lg"
              type="email"
              name="email"
              id="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>

          <div>
            <label className="block mb-1 font-semibold" htmlFor="password">
              Password:
            </label>
            <input
              className="w-full px-4 py-2 border rounded-lg"
              type="password"
              name="password"
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          <button
            type="submit"
            className="w-full bg-black text-white py-2 rounded-lg font-semibold"
          >
            Login
          </button>
        </form>
        <p className="mt-4 text-center">
          Don't have an account?{" "}
          <a href="/signup" className="text-blue-500">
            Sign Up
          </a>
        </p>
      </div>
    </div>
  );
};

export default Login;
