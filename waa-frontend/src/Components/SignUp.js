import React from 'react'
import {useFormik} from 'formik'
import * as yup from 'yup'
import {Button, FormControlLabel, Grid, Radio, RadioGroup, TextField} from '@mui/material'
import studentService from '../services/student'
import facultyService from '../services/faculty'
import {useKeycloak} from '@react-keycloak/web'
import RenderIf from './common/RenderIf'


const validationSchema = yup.object().shape({
	email: yup.string('Enter your email')
			  .email('Enter a valid email')
			  .required('Email is required'),
	firstName: yup.string()
				  .required('FirstName is required'),
	lastName: yup.string()
				 .required('LastName is required'),
	gpa: yup.number(),
	password: yup.string('Enter your password')
				 .min(8, 'Password should be of minimum 8 characters length')
				 .required('Password is required'),
	confirmPassword: yup.string('Enter your password')
						.oneOf([yup.ref('password'), null], 'Passwords must match')
						.min(8, 'Password should be of minimum 8 characters length')
						.required('Password is required')
})

const Signup = () => {
	const { keycloak: { login } } = useKeycloak()

	const { errors, touched, handleSubmit, values, handleChange } = useFormik({
		initialValues: {
			firstName: '', lastName: '', email: '', password: '', confirmPassword: '', role: '', gpa: 0
		}, validationSchema,
		onSubmit: async (values) => {
			if(values.role === 'student') {
				await studentService.createStudent(values)
			} else {
				await facultyService.createFaculty(values)
			}
			login()
		}
	})

	return (
		<div style={{ border: '1px solid #e4e4e4', padding: '30px', paddingTop: '1px', width: '50vh', height: 'auto' }}>
			<form onSubmit={handleSubmit}>
				<h1>Sign up</h1>
				<Grid container direction={'column'} spacing={5}>
					<Grid item>
						<TextField
							fullWidth
							id="firstName"
							name="firstName"
							label="firstName"
							variant="outlined"
							value={values.firstName}
							onChange={handleChange}
							error={touched.firstName && Boolean(errors.firstName)}
							helperText={touched.firstName && errors.firstName}
						/>
					</Grid>
					<Grid item>
						<TextField
							fullWidth
							id="lastName"
							name="lastName"
							label="lastName"
							variant="outlined"
							value={values.lastName}
							onChange={handleChange}
							error={touched.lastName && Boolean(errors.lastName)}
							helperText={touched.lastName && errors.lastName}
						/>
					</Grid>
					<Grid item>
						<TextField
							fullWidth
							id="email"
							name="email"
							label="email"
							variant="outlined"
							value={values.email}
							onChange={handleChange}
							error={touched.email && Boolean(errors.email)}
							helperText={touched.email && errors.email}
						/>
					</Grid>
					<Grid item>
						<TextField
							fullWidth
							id="password"
							name="password"
							label="password"
							variant="outlined"
							type="password"
							value={values.password}
							onChange={handleChange}
							error={touched.password && Boolean(errors.password)}
							helperText={touched.password && errors.password}
						/>
					</Grid>
					<Grid item>
						<TextField
							fullWidth
							type="password"
							id="confirmPassword"
							name="confirmPassword"
							label="confirmPassword"
							variant="outlined"
							value={values.confirmPassword}
							onChange={handleChange}
							error={touched.confirmPassword && Boolean(errors.confirmPassword)}
							helperText={touched.confirmPassword && errors.confirmPassword}
						/>
					</Grid>
					<RenderIf condition={values.role === 'student'}>
						<Grid item>
							<TextField
								fullWidth
								type="number"
								id="gpa"
								name="gpa"
								label="gpa"
								variant="outlined"
								value={values.gpa}
								onChange={handleChange}
								error={touched.gpa && Boolean(errors.gpa)}
								helperText={touched.gpa && errors.gpa}
							/>
						</Grid>
					</RenderIf>
					<Grid item>
						<RadioGroup row aria-labelledby="role-label" name="role"
									value={values.role}
									onChange={handleChange}>
							<FormControlLabel value="student" control={<Radio/>} label="Student"/>
							<FormControlLabel value="faculty" control={<Radio/>} label="Faculty"/>
						</RadioGroup>
					</Grid>

					<Grid item>
						<Button color="primary" variant="contained" fullWidth type="submit"> Sign Up </Button>
					</Grid>
				</Grid>
			</form>
		</div>
	)
}

export default Signup
