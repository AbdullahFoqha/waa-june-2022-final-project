import client from './client'


const baseUrl = '/faculties'

export const getFaculties = async () => await client.get(`${baseUrl}`)

const getFacultyById = async (id) => await client.get(`${baseUrl}/${id}`)

const deleteFacultyById = async (id) => await client.delete(`${baseUrl}/${id}`)

const updateFacultyById = async (id) => await client.put(`${baseUrl}/${id}`)

const createFaculty = async (faculty) => await client.post(`${baseUrl}`, faculty)

export default {
	getFacultyById, deleteFacultyById, updateFacultyById, createFaculty
}
