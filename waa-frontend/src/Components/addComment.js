import React from 'react'
import Box from '@mui/material/Box'
import Typography from '@mui/material/Typography'
import {useFormik} from 'formik'
import {TextField} from '@mui/material'
import Button from '@mui/material/Button'
import Modal from '@mui/material/Modal'
import * as yup from 'yup'


const AddComment = ({ open, onClose }) => {
	const validationSchema = yup.object().shape({
		comment: yup.string().required('Comment is required')
	})

	const { errors, touched, handleSubmit, values, handleChange } = useFormik({
		initialValues: {
			comment: ''
		}, validationSchema, onSubmit: ({ comment }) => {
			//call backend
			onClose(comment)
		}
	})

	return (
		<Modal
			open={open}
			onClose={() => onClose()}>
			<Box sx={[styles.modal, { width: '20rem' }]}>
				<Box sx={{ display: 'flex', justifyContent: 'center' }}>
					<Typography id="modal-modal-title" variant="h6" component="h2">
						Add Comment
					</Typography>
				</Box>
				<hr/>
				<Box sx={{ display: 'flex', flexDirection: 'column' }}>
					<form onSubmit={handleSubmit}>
						<Box style={styles.card}>
							<TextField
								id="comment"
								name="comment"
								label="comment"
								variant="outlined"
								value={values.comment}
								onChange={handleChange}
								error={touched.comment && Boolean(errors.comment)}
								helperText={touched.comment && errors.comment}
							/>
							<Button type="submit" variant="outlined" style={{ marginTop: 15 }}>Add</Button>
						</Box>
					</form>
				</Box>
			</Box>
		</Modal>
	)
}

const styles = {
	modal: {
		borderRadius: 5, position: 'absolute', top: '50%', left: '50%', transform: 'translate(-50%, -50%)', width: '40rem', bgcolor: 'background.paper', boxShadow: 24, p: 4
	}, card: {
		display: 'flex', flexDirection: 'column', padding: 5
	}
}

export default AddComment
