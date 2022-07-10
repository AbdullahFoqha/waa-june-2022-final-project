import client from "./client";

const baseUrl = "http://localhost:9090/students";

export const getStudents = () => async (onSuccess, onFail) => {
  const response = await client.get(`${baseUrl}`);
  if (response.code === 1) {
    onSuccess(response);
  } else {
    onFail(response);
  }
};

const getStudentById = async (id) => await client.get(`${baseUrl}/${id}`);

const deleteStudentById = async (id) => await client.delete(`${baseUrl}/${id}`);

const updateStudentById = async (id) => await client.put(`${baseUrl}/${id}`);

const createStudent = async (id) => await client.post(`${baseUrl}/${id}`);

export default {
  getStudentById,
  deleteStudentById,
  updateStudentById,
  createStudent,
};
