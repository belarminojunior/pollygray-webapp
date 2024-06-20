import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import authService from "../../services/authService";

const SignUp = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [passwordMatch, setPasswordMatch] = useState(true);
  const navigate = useNavigate();

  const handleSignUp = async (e) => {
    e.preventDefault();
    authService
      .register(firstName, lastName, email, password)
      .then((response) => {
        console.log(response);
        navigate("/login");
      })
      .catch((error) => {
        alert(`Signup failed: ${error}`);
      });
  };

  const handleConfirmPassword = (e) => {
    setConfirmPassword(e.target.value);
    setPasswordMatch(e.target.value === password);
  };

  return (
    <div className="min-h-screen flex flex-col items-center justify-center bg-gray-100">
      <div className="bg-white p-10 rounded-lg shadow-lg w-96">
        <h2 className="text-2xl font-bold mb-5 text-center">Sign Up</h2>
        <h3 className="text-lg font-semibold mb-5 text-center">
          Register Here
        </h3>
        <form action="" onSubmit={handleSignUp} className="space-y-4">
          <div>
            <label htmlFor="firstName" className="block mb-1 font-semibold">
              First Name:
            </label>
            <input
              className="w-full px-4 py-2 border rounded-lg"
              type="text"
              name="firstName"
              id="firstName"
              value={firstName}
              onChange={(e) => setFirstName(e.target.value)}
              required
            />
          </div>

          <div>
            <label htmlFor="lastName" className="block mb-1 font-semibold">
              Last Name:
            </label>
            <input
              className="w-full px-4 py-2 border rounded-lg"
              type="text"
              name="lastName"
              id="lastName"
              value={lastName}
              onChange={(e) => setLastName(e.target.value)}
              required
            />
          </div>

          <div>
            <label htmlFor="email" className="block mb-1 font-semibold">
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
            <label htmlFor="password" className="block mb-1 font-semibold">
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

          <div>
            <label
              htmlFor="confirmPassword"
              className="block mb-1 font-semibold"
            >
              Confirm Password:
            </label>
            <input
              className="w-full px-4 py-2 border rounded-lg"
              type="password"
              name="confirmPassword"
              id="confirmPassword"
              value={confirmPassword}
              onChange={handleConfirmPassword}
              required
            />
            {!passwordMatch && (
              <p className="text-red-500 text-sm mt-1">Passwords don't match</p>
            )}
          </div>
          <button
            className="w-full bg-black text-white py-2 rounded-lg font-semibold"
            type="submit"
          >
            Sign Up
          </button>
        </form>
        <p className="mt-4 text-center">
          Already have an account?{" "}
          <a href="/login" className="text-blue-500">
            Login
          </a>
        </p>
      </div>
    </div>
  );
};

export default SignUp;
