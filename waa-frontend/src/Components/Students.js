import {Grid} from '@mui/material'
import ReactDataTable from './common/DataTable'
import studentService from '../services/student'
import {useEffect, useState} from 'react'
import Comments from './Comments'
import useRole from '../config/security/hooks/useRole'
import RenderIf from './common/RenderIf'
import {useKeycloak} from '@react-keycloak/web'


const StudentsData = () => {
	const [lstStudents, setStudents] = useState([])
	const { isFaculty } = useRole()
	const { keycloak: { tokenParsed: {} } } = useKeycloak()

	const fetchData = async () => {
		const { data } = await studentService.getStudents()
		setStudents(data)
	}

	useEffect(() => {
		fetchData()
	}, [])

	const handleDelete = async (comment, studentId) => {
		await studentService.deleteCommentById(comment.id)
		let index = lstStudents.findIndex(s => s.id === studentId)
		let cloned = [...lstStudents[index].comments]
		cloned = cloned.filter(c => c.id !== comment.id)
		lstStudents[index].comments = cloned
		setStudents([...lstStudents])
	}

	const columns = [{
		name: 'First Name', selector: (row) => row.firstName
	}, {
		name: 'Last Name', selector: (row) => row.lastName
	}, {
		name: 'Email', selector: (row) => row.email
	}, {
		name: 'Major', selector: (row) => row.major?.name
	}, {
		name: 'GPA', selector: (row) => row.gpa
	}, {
		name: 'Comments', selector: (row) => (
			<RenderIf condition={isFaculty}>
				<Comments comments={row.comments} studentId={row.userId} onDelete={(comment) => handleDelete(comment, row.id)}/>
			</RenderIf>
		)
	}]

	return (
		<Grid container>
			<Grid item md={12} width="100rem">
				<ReactDataTable data={lstStudents} columns={columns}/>
			</Grid>
		</Grid>
	)
}

export default StudentsData
