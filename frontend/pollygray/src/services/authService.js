import axiosInstance from "../api/axios";

const login = async (email, password) => {
  const response = await axiosInstance.post("/login", { email, password });
  return response.data;
};

const register = async (firstName, lastName, email, password) => {
  const response = await axiosInstance.post("/register", {
    firstName,
    lastName,
    email,
    password,
  });
  return response.data;
};

export default {
  login,
  register,
};
