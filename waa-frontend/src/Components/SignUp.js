import React from 'react'
import {Formik, Field} from 'formik'
import * as yup from 'yup'
import {Button, Grid, TextField} from '@mui/material'
import {useKeycloak} from '@react-keycloak/web'


const validationSchema = yup.object().shape({
	email: yup
	.string('Enter your email')
	.email('Enter a valid email')
	.required('Email is required'),
	password: yup
	.string('Enter your password')
	.min(8, 'Password should be of minimum 8 characters length')
	.required('Password is required'),
	confirmPassword: yup
	.string('Enter your password')
	.min(8, 'Password should be of minimum 8 characters length')
	.required('Password is required')
})

const Signup = () => {
	const { keycloak: { register } } = useKeycloak()

	return (
		<Formik
			initialValues={{
				email: '',
				password: ''
			}}
			validationSchema={validationSchema}
			onSubmit={(values) => {
				register()
			}}
		>
			{({
				errors,
				touched
			}) => (
				<div
					style={{
						border: '1px solid #e4e4e4',
						padding: '30px',
						paddingTop: '1px',
						width: '50vh',
						height: 'auto'
					}}
				>
					<form>
						<h1>Sign up</h1>
						<Grid container direction={'column'} spacing={5}>
							<Grid item>
								<Field
									id="firstName"
									name="firstName"
									render={({ field }) => (
										<TextField fullWidth label="First Name" {...field} />
									)}
									variant="outlined"
									margin="dense"
								/>
								{errors.firstName && touched.firstName ? (
									<div style={{ color: 'red' }}>{errors.firstName}</div>
								) : null}
							</Grid>
							<Grid item>
								<Field
									id="lastName"
									name="lastName"
									render={({ field }) => (
										<TextField fullWidth label="Last Name" {...field} />
									)}
									variant="outlined"
									margin="dense"
								/>
								{errors.lastName && touched.lastName ? (
									<div style={{ color: 'red' }}>{errors.lastName}</div>
								) : null}
							</Grid>
							<Grid item>
								<Field
									id="email"
									name="email"
									render={({ field }) => (
										<TextField fullWidth label="Email" {...field} />
									)}
									variant="outlined"
									margin="dense"
								/>
								{errors.email && touched.email ? (
									<div style={{ color: 'red' }}>{errors.email}</div>
								) : null}
							</Grid>
							<Grid item>
								<Field
									id="password"
									name="password"
									render={({ field }) => (
										<TextField
											fullWidth
											label="Password"
											type="password"
											{...field}
										/>
									)}
									variant="outlined"
									margin="dense"
								/>
								{errors.password && touched.password ? (
									<div style={{ color: 'red' }}>{errors.password}</div>
								) : null}
							</Grid>
							<Grid item>
								<Field
									id="confirmPassword"
									name="confirmPassword"
									render={({ field }) => (
										<TextField
											fullWidth
											label="Confirm Password"
											type="password"
											{...field}
										/>
									)}
									variant="outlined"
									margin="dense"
								/>
								{errors.confirmPassword && touched.confirmPassword ? (
									<div style={{ color: 'red' }}>{errors.confirmPassword}</div>
								) : null}
							</Grid>
							<Grid item>
								<Button
									color="primary"
									variant="contained"
									fullWidth
									type="submit"
								>
									Sign Up
								</Button>
							</Grid>
						</Grid>
					</form>
				</div>
			)}
		</Formik>
	)
}

export default Signup
