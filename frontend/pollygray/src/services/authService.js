import axios from "axios";

const API_URL = "api/auth";

const login = (email, password) => {
  return axios.post(`${API_URL}/login`, { email, password });
};

const register = (firstName, lastName, email, password) => {
  return axios.post(`${API_URL}/register`, {
    firstName,
    lastName,
    email,
    password,
  });
};

export default {
  login,
  register,
};