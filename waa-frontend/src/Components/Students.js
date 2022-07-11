import {Grid} from '@mui/material'
import ReactDataTable from './common/DataTable'
import {getStudents} from '../services/student'
import {useEffect, useState} from 'react'
import Comments from './Comments'
import useRole from '../config/security/hooks/useRole'
import RenderIf from './common/RenderIf'


const StudentsData = () => {
	const init = [{
		id: '1',
		firstName: 'Yaser',
		lastName: 'Alqasem',
		email: 'yalqasem.miu.edu',
		major: 'Software Engineer',
		gpa: '3.50',
		comments: [{
			id: '1',
			text: 'ali1',
			faculty: {
				id: '9ae0c255-b255-423c-8628-07ce47e70cb7',
				name: 'Anass'
			}
		}, {
			id: '2',
			text: 'ali2',
			faculty: {
				id: '7c9b9510-b0ae-42e0-b598-ec36cadf4ce4',
				name: 'Umur'
			}
		}]
	}, {
		id: '2',
		firstName: 'Abdullah',
		lastName: 'Alfoqha',
		email: 'alfoqha.miu.edu',
		major: 'Computer Science',
		gpa: '3.75',
		comments: [{
			id: '3',
			text: 'One',
			faculty: {
				id: '7c9b9510-b0ae-42e0-b598-ec36cadf4ce4',
				name: 'Umur'
			}
		}, {
			id: '4',
			text: 'Two',
			faculty: {
				id: '7c9b9510-b0ae-42e0-b598-ec36cadf4ce4',
				name: 'Umur'
			}
		}]
	}]
	const [lstStudents, setStudents] = useState(init)
	const { isFaculty } = useRole()

	useEffect(() => {
		const fetchData = async () => {
			await getStudents()(setStudents)
		}
		//fetchData();
	}, [])

	const handleDelete = (comment, studentId) => {
		let index = lstStudents.findIndex(s => s.id === studentId)
		let cloned = [...lstStudents[index].comments]
		cloned = cloned.filter(c => c.id !== comment.id)
		lstStudents[index].comments = cloned
		setStudents([...lstStudents])
	}

	const columns = [{
		name: 'First Name',
		selector: (row) => row.firstName
	}, {
		name: 'Last Name',
		selector: (row) => row.lastName
	}, {
		name: 'Email',
		selector: (row) => row.email
	}, {
		name: 'Major',
		selector: (row) => row.major
	}, {
		name: 'GPA',
		selector: (row) => row.gpa
	}, {
		name: 'Comments',
		selector: (row) => (
			<RenderIf condition={isFaculty}>
				<Comments comments={row.comments} onDelete={(comment) => handleDelete(comment, row.id)}/>
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
