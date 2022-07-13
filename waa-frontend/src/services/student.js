import client from './client'


const baseUrl = '/students'

export const getStudents = async () => await client.get(`${baseUrl}`)

export const getStudentById = async (id) =>
	await client.get(`${baseUrl}/${id}`)

const deleteStudentById = async (id) => await client.delete(`${baseUrl}/${id}`)

const updateStudentById = async (id) => await client.put(`${baseUrl}/${id}`)

const createStudent = async (student) =>
	await client.post(`${baseUrl}`, student)

const addComment = async (comment) => await client.post(`${baseUrl}/addComment`, comment)

export default {
	getStudentById, deleteStudentById, updateStudentById, createStudent, addComment
}
