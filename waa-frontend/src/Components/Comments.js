import {useState} from 'react'
import Box from '@mui/material/Box'
import Button from '@mui/material/Button'
import Typography from '@mui/material/Typography'
import Modal from '@mui/material/Modal'
import {Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow} from '@mui/material'
import DeleteOutlinedIcon from '@mui/icons-material/DeleteOutlined'
import RenderIf from './common/RenderIf'
import {useKeycloak} from '@react-keycloak/web'
import AddComment from './addComment'


const style = {
	borderRadius: 5,
	position: 'absolute',
	top: '50%',
	left: '50%',
	transform: 'translate(-50%, -50%)',
	width: '40rem',
	bgcolor: 'background.paper',
	boxShadow: 24,
	p: 4
}

const Comments = ({ comments, onDelete }) => {
	const { keycloak: { subject: userId, tokenParsed: { given_name } } } = useKeycloak()
	const [open, setOpen] = useState(false)
	const handleOpen = () => setOpen(true)
	const handleClose = () => setOpen(false)

	const [addComment, setAddComment] = useState(false)
	const handleCommentOpen = () => setAddComment(true)
	const handleCommentClose = (comment) => {
		if(comment) {
			comments.push({ text: comment, faculty: { name: given_name, id: userId } })
		}
		setAddComment(false)
	}

	return (
		<div>
			<Button
				color="primary"
				variant="outlined"
				fullWidth
				type="button"
				onClick={() => handleOpen()}>
				Comments
			</Button>
			<Modal
				open={open}
				onClose={handleClose}>
				<Box sx={style}>
					<Box sx={{
						display: 'flex', justifyContent: 'space-between'
					}}>
						<Typography id="modal-modal-title" variant="h6" component="h2">
							Comments
						</Typography>
						<Button variant={'outlined'} onClick={() => handleCommentOpen()}>
							Add
						</Button>
					</Box>
					<hr/>
					<TableContainer component={Paper}>
						<Table aria-label="customized table">
							<TableHead>
								<TableRow>
									<TableCell>Comment</TableCell>
									<TableCell>Faculty</TableCell>
									<TableCell>Actions</TableCell>
								</TableRow>
							</TableHead>
							<TableBody>
								{comments.map((comment) => (
									<TableRow key={comment.text}>
										<TableCell>
											{comment.text}
										</TableCell>
										<TableCell>
											{comment.faculty.name}
										</TableCell>
										<TableCell>
											<RenderIf condition={userId === comment.faculty.id}>
												<DeleteOutlinedIcon style={{ cursor: 'pointer' }}
																	onClick={() => onDelete(comment)}/>
											</RenderIf>
										</TableCell>
									</TableRow>
								))}
							</TableBody>
						</Table>
					</TableContainer>
				</Box>
			</Modal>
			<AddComment open={addComment} onClose={handleCommentClose}/>
		</div>
	)
}

export default Comments
