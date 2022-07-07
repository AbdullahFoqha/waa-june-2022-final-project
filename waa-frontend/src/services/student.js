import client from './client'


const baseUrl = '/students'

const getStudents = async () => await client.get(`${baseUrl}`)

const getStudentById = async (id) => await client.get(`${baseUrl}/${id}`)

const deleteStudentById = async (id) => await client.delete(`${baseUrl}/${id}`)

const updateStudentById = async (id) => await client.put(`${baseUrl}/${id}`)

const createStudent = async (id) => await client.post(`${baseUrl}/${id}`)

export default {
	getStudents,
	getStudentById,
	deleteStudentById,
	updateStudentById,
	createStudent
}
